package com.example.finance_compass_bot.bot.handlers;

import com.example.finance_compass_bot.bot.replymarkups.ReplyMarkupProvider;
import com.example.finance_compass_bot.financial.FinanceInfoObtainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class StockInfoCommandHandler implements TextCommandHandler{

    private FinanceInfoObtainer financeInfoObtainer;

    @Autowired
    public StockInfoCommandHandler(FinanceInfoObtainer financeInfoObtainer) {
        this.financeInfoObtainer = financeInfoObtainer;
    }

    @Override
    public void handleMessage(AbsSender absSender, Message message, String[] strings) {
        String stockInfo = financeInfoObtainer.getLatestStockInfo(message.getText());
        SendMessage sendMessage = SendMessage.builder()
                .chatId(message.getChatId())
                .text(stockInfo)
                .replyMarkup((ReplyMarkupProvider.getStartReplyMarkup()))
                .build();
        try {
            absSender.execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
