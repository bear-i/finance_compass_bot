package com.example.finance_compass_bot.bot.commands;

import com.example.finance_compass_bot.bot.replymarkups.ReplyMarkupProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class StartCommand extends BotCommand {

    private static final String greetingMessage = "Hello! Here you can find latest info on stock prices.";

    public StartCommand(@Value(("start")) String commandIdentifier, @Value("")String description) {
        super(commandIdentifier, description);
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        try {
            SendMessage sendMessage = SendMessage.builder()
                    .chatId(chat.getId())
                    .replyMarkup(ReplyMarkupProvider.getStartReplyMarkup())
                    .text(greetingMessage)
                    .build();
            absSender.execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
