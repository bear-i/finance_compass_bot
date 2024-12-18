package com.example.finance_compass_bot.bot.replymarkups;

import com.example.finance_compass_bot.bot.commands.TextCommands;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.List;

public class ReplyMarkupProvider {

    public static ReplyKeyboard getStartReplyMarkup(){
        ReplyKeyboard replyKeyboard = ReplyKeyboardMarkup.builder()
                .keyboardRow(new KeyboardRow(
                        List.of(
                                new KeyboardButton(TextCommands.ST_INF.getCommand())
                        )
                ))
                .keyboardRow(new KeyboardRow(
                        List.of(
                                new KeyboardButton(TextCommands.CR_INF.getCommand())
                        )
                ))
                .resizeKeyboard(true)
                .build();
        return replyKeyboard;
    }

    public static ReplyKeyboard getStockListReplyMarkup(){
        ReplyKeyboard replyKeyboard = ReplyKeyboardMarkup.builder()
                .keyboardRow(new KeyboardRow(
                        List.of(
                                new KeyboardButton(TextCommands.IBM.getCommand()),
                                new KeyboardButton(TextCommands.AAPL.getCommand()),
                                new KeyboardButton(TextCommands.TSLA.getCommand())
                        )
                ))
                .resizeKeyboard(true)
                .build();
        return replyKeyboard;
    }

    public static ReplyKeyboard getCryptoListReplyMarkup(){
        ReplyKeyboard replyKeyboard = ReplyKeyboardMarkup.builder()
                .keyboardRow(new KeyboardRow(
                        List.of(
                                new KeyboardButton(TextCommands.BTC.getCommand()),
                                new KeyboardButton(TextCommands.ETH.getCommand()),
                                new KeyboardButton(TextCommands.BNB.getCommand())
                        )
                ))
                .resizeKeyboard(true)
                .build();
        return replyKeyboard;
    }
}
