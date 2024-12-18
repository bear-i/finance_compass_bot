package com.example.finance_compass_bot.bot;

import com.example.finance_compass_bot.bot.commands.TextCommandDispatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class FinanceCompassBot extends TelegramLongPollingCommandBot {

    @Autowired
    private TextCommandDispatcher textCommandDispatcher;

    private final String username;

    public FinanceCompassBot(@Value("${bot.token}")String botToken, @Value("${bot.username}") String username,
                             TextCommandDispatcher textCommandDispatcher) {
        super(botToken);
        this.username = username;
    }

    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public void processNonCommandUpdate(Update update) {
        if(update.hasMessage()&&update.getMessage().hasText()){
            Message message = update.getMessage();
            textCommandDispatcher.processMessage(this, message, new String[]{});
        }
    }
}
