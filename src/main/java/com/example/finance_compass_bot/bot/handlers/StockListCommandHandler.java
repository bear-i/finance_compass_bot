package com.example.finance_compass_bot.bot.handlers;

import com.example.finance_compass_bot.bot.replymarkups.ReplyMarkupProvider;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class StockListCommandHandler implements TextCommandHandler{

    @Override
    public void handleMessage(AbsSender absSender, Message message, String[] strings) {
        SendMessage sendMessage = SendMessage.builder()
                .chatId(message.getChatId())
                .text("Choose stock")
                .replyMarkup(ReplyMarkupProvider.getStockListReplyMarkup())
                .build();
        try {
            absSender.execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
