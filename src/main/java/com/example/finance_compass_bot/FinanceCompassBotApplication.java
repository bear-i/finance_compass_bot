package com.example.finance_compass_bot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.telegram.telegrambots.starter.TelegramBotStarterConfiguration;

@SpringBootApplication
@Import(TelegramBotStarterConfiguration.class)
public class FinanceCompassBotApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinanceCompassBotApplication.class, args);
    }

}
