package bot.bymin.telegram.service.receiver;

import bot.bymin.telegram.service.exception.NoneException;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class Receiver {

    public String name;
    public Update update;

    public Receiver next = null;

    public Object result;

    public Receiver(String name, Update update) {
        this.name = name;
        this.update = update;
    }

    public Receiver setNext(Receiver next) {
        this.next = next;
        return next;
    }

    public final String support(String text) throws NoneException {
        if (resolve(text)) {
            done(text);
        } else if (next != null) {
            this.next.support(text);
            return "properties";
        } else {
            throw new NoneException();
        }
        return "screen";
    }

    public abstract boolean resolve(String text);

    public abstract void done(String text) throws NoneException;

    public void start(String play, String pattern){
        // 클래스 정보를 가져온다.
        try {
            Class<?> cls = Class.forName("bot.bymin.telegram.service.reflect.ReflectCls");
            Object obj = cls.newInstance();
            Method method = cls.getMethod(play, String.class);
            setResult(method.invoke(obj,pattern));
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}