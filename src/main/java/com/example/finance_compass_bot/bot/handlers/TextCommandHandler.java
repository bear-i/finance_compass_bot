package com.example.finance_compass_bot.bot.handlers;

import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;

public interface TextCommandHandler {
    void handleMessage(AbsSender absSender, Message message, String[] strings);
}
