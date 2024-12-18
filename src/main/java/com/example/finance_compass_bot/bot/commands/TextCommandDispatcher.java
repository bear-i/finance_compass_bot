package com.example.finance_compass_bot.bot.commands;

import com.example.finance_compass_bot.bot.handlers.TextCommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;

import java.util.HashMap;

@Component
public class TextCommandDispatcher extends BaseTextCommand {

    private HashMap<String, TextCommandHandler> commandHandlerMap;

    public TextCommandDispatcher(@Value("common") String identifier, @Value("") String description) {
        super(identifier, description);
    }

    @Override
    public void processMessage(AbsSender absSender, Message message, String[] strings){
        String command = message.getText();
        TextCommandHandler commandHandler = commandHandlerMap.get(command);
        if(commandHandler!=null){
            commandHandler.handleMessage(absSender, message, new String[]{});
        } else{
            System.out.println("Command doesn't exist: " + message.getText());
        }
    }

    @Autowired
    public void setCommandHandlerMap(HashMap<String, TextCommandHandler> commandHandlerMap) {
        this.commandHandlerMap = commandHandlerMap;
    }
}
