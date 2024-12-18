package com.example.finance_compass_bot.bot.commands;

public enum TextCommands {
    ST_INF("Get stock info"),
    IBM("IBM"),
    AAPL("AAPL"),
    TSLA("TSLA"),
    CR_INF("Get cryptocurrencies info"),
    BTC("BTC"),
    ETH("ETH"),
    BNB("BNB");

    private String command;

    TextCommands(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
