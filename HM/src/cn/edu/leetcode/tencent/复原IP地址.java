package cn.edu.leetcode.tencent;

import java.util.ArrayList;
import java.util.List;

public class 复原IP地址 {
    public static void main(String[] args) {
        System.out.println("abc".substring(0,1));
    }
    public List<String> restoreIpAddresses(String s) {
        List<String> list=new ArrayList<>();
        char[] chars = s.toCharArray();
        int num=chars[0]-'0';
        int flag=3;
        int length = chars.length;
        for (int i = 0; i < length; i++) {
            if (length-(3-flag)-i<0){
                num+=chars[i]-'0';
                i++;
            }
            generate(chars,i,flag);
        }

        return list;
    }
    String generate(char[] chars,int start,int flag){
        for (int i = 0; i < 3; i++) {
            if (chars.length-i-1<=flag*3&&chars.length-i-1>=flag){
                return new String(chars,start,i+1)+generate(chars,i+1,flag-1);
            }
        }

        return null;
    }
}
