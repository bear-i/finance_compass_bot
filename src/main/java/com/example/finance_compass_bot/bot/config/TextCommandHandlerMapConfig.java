package com.example.finance_compass_bot.bot.config;

import com.example.finance_compass_bot.bot.commands.TextCommands;
import com.example.finance_compass_bot.bot.handlers.CryptoInfoCommandHandler;
import com.example.finance_compass_bot.bot.handlers.CryptoListCommandHandler;
import com.example.finance_compass_bot.bot.handlers.StockInfoCommandHandler;
import com.example.finance_compass_bot.bot.handlers.StockListCommandHandler;
import com.example.finance_compass_bot.bot.handlers.TextCommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
public class TextCommandHandlerMapConfig {

    private StockListCommandHandler stockListCommandHandler;
    private StockInfoCommandHandler stockInfoCommandHandler;
    private CryptoListCommandHandler cryptoListCommandHandler;
    private CryptoInfoCommandHandler cryptoInfoCommandHandler;

    @Autowired
    public TextCommandHandlerMapConfig(StockListCommandHandler stockListCommandHandler,
                                       StockInfoCommandHandler stockInfoCommandHandler,
                                       CryptoListCommandHandler cryptoListCommandHandler,
                                       CryptoInfoCommandHandler cryptoInfoCommandHandler) {
        this.stockListCommandHandler = stockListCommandHandler;
        this.stockInfoCommandHandler = stockInfoCommandHandler;
        this.cryptoListCommandHandler = cryptoListCommandHandler;
        this.cryptoInfoCommandHandler = cryptoInfoCommandHandler;
    }

    @Bean
    public HashMap<String, TextCommandHandler> commandHandlerMap(){
        HashMap<String, TextCommandHandler> commandHandlerMap = new HashMap<>();
        commandHandlerMap.put(TextCommands.ST_INF.getCommand(), stockListCommandHandler);
        commandHandlerMap.put(TextCommands.IBM.getCommand(), stockInfoCommandHandler);
        commandHandlerMap.put(TextCommands.AAPL.getCommand(), stockInfoCommandHandler);
        commandHandlerMap.put(TextCommands.TSLA.getCommand(), stockInfoCommandHandler);
        commandHandlerMap.put(TextCommands.CR_INF.getCommand(), cryptoListCommandHandler);
        commandHandlerMap.put(TextCommands.BTC.getCommand(), cryptoInfoCommandHandler);
        commandHandlerMap.put(TextCommands.BNB.getCommand(), cryptoInfoCommandHandler);
        commandHandlerMap.put(TextCommands.ETH.getCommand(), cryptoInfoCommandHandler);
        return commandHandlerMap;
    }
}
