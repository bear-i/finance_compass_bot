package com.example.finance_compass_bot.bot.commands;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.IBotCommand;

public abstract class BaseTextCommand implements IBotCommand {
    private final String identifier;
    private final String description;

    public BaseTextCommand(String identifier, String descrription) {
        this.identifier = identifier;
        this.description = descrription;
    }

    @Override
    public String getCommandIdentifier() {
        return identifier;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
