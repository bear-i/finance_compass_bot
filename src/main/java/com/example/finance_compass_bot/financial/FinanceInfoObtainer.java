package com.example.finance_compass_bot.financial;

public interface FinanceInfoObtainer {
    String getLatestStockInfo(String stockSymbol);

    String getLatestCryptoInfo(String cryptoSymbol);
}
