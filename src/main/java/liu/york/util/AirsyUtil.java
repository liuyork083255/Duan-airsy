package liu.york.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Administrator on 2017/8/19.
 */
public class AirsyUtil {

    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }

    public static String getCurrentTime(){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
}
