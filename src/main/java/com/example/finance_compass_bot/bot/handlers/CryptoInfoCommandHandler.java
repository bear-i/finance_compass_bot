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
public class CryptoInfoCommandHandler implements TextCommandHandler {
    private FinanceInfoObtainer financeInfoObtainer;

    @Autowired
    public CryptoInfoCommandHandler(FinanceInfoObtainer financeInfoObtainer) {
        this.financeInfoObtainer = financeInfoObtainer;
    }

    @Override
    public void handleMessage(AbsSender absSender, Message message, String[] strings) {
        String cryptoInfo = financeInfoObtainer.getLatestCryptoInfo(message.getText());
        SendMessage sendMessage = SendMessage.builder()
                .chatId(message.getChatId())
                .text(cryptoInfo)
                .replyMarkup((ReplyMarkupProvider.getStartReplyMarkup()))
                .build();
        try {
            absSender.execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
