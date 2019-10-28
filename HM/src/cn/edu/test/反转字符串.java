package cn.edu.test;

import java.util.Scanner;

public class 反转字符串 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        StringBuffer s=new StringBuffer(scanner.nextLine());
        String reverse = String.valueOf(s.reverse());
        String[] split = reverse.split("\\s");
        StringBuffer stringBuffer=new StringBuffer();
        for (String s1 : split) {
            if (!s1.equals("")){
                StringBuffer tmp=new StringBuffer(s1.trim());
                tmp.reverse();
                stringBuffer.append(tmp+" ");
            }
        }
        if (stringBuffer.length()>1){
            String substring = stringBuffer.substring(0, stringBuffer.length() - 1);
            System.out.println(substring);
            return;
        }
        System.out.println(stringBuffer);
    }
}
