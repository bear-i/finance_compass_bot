package com.example.finance_compass_bot.financial;

import com.crazzyghost.alphavantage.AlphaVantage;
import com.crazzyghost.alphavantage.cryptocurrency.response.CryptoResponse;
import com.crazzyghost.alphavantage.cryptocurrency.response.CryptoUnit;
import com.crazzyghost.alphavantage.parameters.Interval;
import com.crazzyghost.alphavantage.parameters.OutputSize;
import com.crazzyghost.alphavantage.timeseries.response.StockUnit;
import com.crazzyghost.alphavantage.timeseries.response.TimeSeriesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AlphaVantageFinanceInfoObtainer implements FinanceInfoObtainer{
    private AlphaVantage alphaVantage;

    @Autowired
    public AlphaVantageFinanceInfoObtainer(AlphaVantage alphaVantage) {
        this.alphaVantage = alphaVantage;
    }

    @Override
    public String getLatestStockInfo(String stockSymbol) {
        TimeSeriesResponse response = alphaVantage
                .timeSeries()
                .intraday()
                .forSymbol(stockSymbol)
                .interval(Interval. SIXTY_MIN)
                .outputSize(OutputSize.FULL)
                .fetchSync();
        StringBuilder stringResponse = new StringBuilder();

        Optional<StockUnit> optionalStockUnit = response.getStockUnits().stream().findFirst();
        if(optionalStockUnit.isEmpty()){
            stringResponse = stringResponse.append("No info on this stock was found");
        } else {
            StockUnit stockUnit = optionalStockUnit.get();
            stringResponse.append("High price : " + stockUnit.getHigh() + "\n");
            stringResponse.append("Low price : " + stockUnit.getLow() + "\n");
            stringResponse.append("Open price : " + stockUnit.getOpen() + "\n");
            stringResponse.append("Close price : " + stockUnit.getClose() + "\n");
            stringResponse.append("Volume: " + stockUnit.getVolume() + "\n");
            stringResponse.append("Adjusted close price: " + stockUnit.getAdjustedClose() + "\n");
            stringResponse.append("Dividend amount: " + stockUnit.getDividendAmount() + "\n");
            stringResponse.append("Split coefficient: " + stockUnit.getSplitCoefficient() + "\n");
            stringResponse.append("On date/time: " + stockUnit.getDate() + " ");
        }
        return stringResponse.toString();
    }

    @Override
    public String getLatestCryptoInfo(String cryptoSymbol) {
        StringBuilder stringResponse = new StringBuilder();
        try {
            CryptoResponse response = alphaVantage
                    .crypto()
                    .daily()
                    .forSymbol(cryptoSymbol)
                    .market("USD")
                    .fetchSync();
            System.out.println(response.getMetaData().toString());
            System.out.println(response.getErrorMessage());

            Optional<CryptoUnit> optionalCryptoUnit = response.getCryptoUnits().stream().findFirst();
            if (optionalCryptoUnit.isEmpty()) {
                stringResponse.append("No info on this cryptocurrency was found");
            } else {
                CryptoUnit cryptoUnit = optionalCryptoUnit.get();
                stringResponse.append("High price in USD:" + cryptoUnit.getHighUSD());
                stringResponse.append("Low price in USD:" + cryptoUnit.getLowUSD());
                stringResponse.append("Open price in USD:" + cryptoUnit.getOpenUSD());
                stringResponse.append("Close price in USD:" + cryptoUnit.getCloseUSD());
                stringResponse.append("On date/time" + cryptoUnit.getDate());
            }
        }catch(NullPointerException e){
            stringResponse.append("No info on this cryptocurrency was found");
        }
            return stringResponse.toString();
        }
    }
