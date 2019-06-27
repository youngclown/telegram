package bot.bymin.telegram.service.receiver;

import bot.bymin.telegram.service.exception.NoneException;
import org.telegram.telegrambots.meta.api.objects.Update;

public class PropertiesReceiver extends Receiver {
    private static final String receiverNm = "pr";
    public PropertiesReceiver(Update update) {
        super(receiverNm, update);
    }

    public boolean resolve(String text) {
        return text.contains(super.name);
    }

    public void done(String text) throws NoneException {
        throw new NoneException();
    }
}
