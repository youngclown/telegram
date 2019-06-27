package bot.bymin.telegram.service.receiver;

import bot.bymin.telegram.service.exception.NoneException;
import org.telegram.telegrambots.meta.api.objects.Update;

public class ScreenReceiver extends Receiver {
    private static final String receiverNm = "sc";
    public ScreenReceiver(Update update) {
        super(receiverNm, update);
    }

    public boolean resolve(String text) {
        return text.contains(super.name);
    }

    public void done(String text) throws NoneException {
        String pattern;
        if(text.contains("abcd")) {
            pattern = "http://url/two";
        } else {
            throw new NoneException();
        }

        start(receiverNm, pattern);
    }
}