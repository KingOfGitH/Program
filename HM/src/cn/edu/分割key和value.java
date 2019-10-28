package cn.edu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class 分割key和value {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s = scanner.nextLine();
        String[] s1 = s.split("\\s");
        String[] s2 = s1[2].split(s1[0]);
        String[] s3=new String[2];
        Map<String ,String > map=new TreeMap<>();
        int count=0;
        for (String s4 : s2) {
            s3=s4.split(s1[1]);
            if (!s3[0].trim().equals("")&&!s3[1].trim().equals("")){
                map.put(s3[0],s3[1]);
                count++;
            }
        }
        System.out.println(count);
        for (String s4 : map.keySet()) {
            System.out.println(s4+" "+map.get(s4));
        }

    }
}
