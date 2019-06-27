package bot.bymin.telegram.service.reflect;

import bot.bymin.telegram.service.exception.NoneException;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class ReflectCls {

    public InputStream sc(String urlServer) throws NoneException{
        System.out.println(urlServer);
        if (urlServer != null) {
            try {
                URL url = new URL(urlServer);
                URLConnection uc = url.openConnection();
                uc.setDoOutput(true);  // 스트림 출력 설정
                uc.setDoInput(true);    // 스트림 입력 설정 -- 기본적으로 입력 스트림

                return uc.getInputStream();
            } catch (IOException e) {
                e.printStackTrace();
                throw new NoneException();
            }
        }
        throw new NoneException();
    }



    public void pr(String pattern) {
        System.out.println(pattern);
    }


}
