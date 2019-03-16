package cn.dhu.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtils {
    public
    static String toDate(Date date){
        DateFormat dateFormat=new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss:SSS");
        return dateFormat.format(date);
    }
}
