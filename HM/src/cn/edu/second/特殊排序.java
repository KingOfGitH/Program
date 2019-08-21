package cn.edu.second;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 特殊排序 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
        s=s.trim();
        if (s.equals("")){
            return;
        }
        String[] split = s.split(",");
        Comparator comparator=new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                String s1= (String) o1+o2;
                String s2= (String) o2+o1;
                return s1.compareTo(s2);
            }
        };
        Arrays.sort(split, comparator);
        StringBuffer stringBuffer=new StringBuffer();
        for (String s1 : split) {
            stringBuffer.append(s1);
        }
        System.out.println(stringBuffer);
    }
}
