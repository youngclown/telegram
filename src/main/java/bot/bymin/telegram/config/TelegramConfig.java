package bot.bymin.telegram.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class TelegramConfig {

    @Value("${telegram.bot.name}")
    private String telegramBotName;

    @Value("${telegram.bot.token}")
    private String telegramBotToken;
}
