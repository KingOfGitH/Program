package cn.edu.dhu.ssm.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhbr
 * @date 2019/6/19 17:22
 */
public class DateUtils {

    public static String  date2String(Date date,String patt){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(patt);
        String format = simpleDateFormat.format(date);

        return format;
    }

    public static Date string2Date(String string,String patt) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(patt);
        Date parse = simpleDateFormat.parse(string);
        return parse;
    }
}
