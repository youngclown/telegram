package bot.bymin.telegram;

import bot.bymin.telegram.config.TelegramConfig;
import bot.bymin.telegram.service.PlayBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@SpringBootApplication
public class TelegramApplication implements CommandLineRunner {

    @Autowired
    private TelegramConfig config;

    public static void main(String[] args) {
        SpringApplication.run(TelegramApplication.class, args);

    }

    @Override
    public void run(String... args) {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();

        try {
            PlayBot playBot = new PlayBot(config);
            telegramBotsApi.registerBot(playBot);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }


    }



}
