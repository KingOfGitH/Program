package cn.edu.dhu.util;

import java.io.UnsupportedEncodingException;

public class ChangeEncoding {
    public static String  ChangeEncoding(String str){
        String result = null;
        if (!(str == null || str.length() == 0)) {
            try {
                result = new String(str.getBytes("iso-8859-1"), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
