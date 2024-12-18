package com.example.finance_compass_bot.financial.config;

import com.crazzyghost.alphavantage.AlphaVantage;
import com.crazzyghost.alphavantage.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AlphaVantageConfig {

    private final String AVKey;

    public AlphaVantageConfig(@Value("${alphavantage.key}") String AVKey) {
        this.AVKey = AVKey;
    }

    @Bean
    public AlphaVantage alphavantage(){
        Config cfg = Config.builder()
                .key(AVKey)
                .timeOut(10)
                .build();
        AlphaVantage.api().init(cfg);
        return AlphaVantage.api();
    }
}
