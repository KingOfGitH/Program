package cn.edu.dhu.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhbr
 * @date 2019/4/19 21:20
 */
public class StringToDateConverter implements Converter<String , Date> {

    @Override
    public Date convert(String source) {
        if (source ==null){
            throw new RuntimeException("请您传入数据");
        }
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        try {
            return dateFormat.parse(source);
        } catch (Exception e) {
            throw new RuntimeException("数据类型转换出错");
        }
    }
}
