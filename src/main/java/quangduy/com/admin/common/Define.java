package quangduy.com.admin.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Define {
    public static String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static String getCurrenDatetime(){

        return new SimpleDateFormat(DATE_FORMAT).format(new Date());
    }
}
