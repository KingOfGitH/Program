package cn.edu.leetcode.tencent;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class 排序 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s=scanner.next();
        int n=scanner.nextInt();
        String[] strings=new String[n];
        for (int i = 0; i < n; i++) {
            strings[i]=scanner.next();
        }
        scanner.close();
        HashMap<Character, Integer> map = new HashMap<>(26);
        for (int i = 0; i < 26; i++) {
            map.put(s.charAt(i),i);
        }

        Arrays.sort(strings, (o1, o2) -> {
            int min=Math.min(o1.length(),o2.length());
            for (int i = 0; i < min; i++) {
                if (map.get(o1.charAt(i))>map.get(o2.charAt(i))){
                    return 1;
                }else if (map.get(o1.charAt(i))<map.get(o2.charAt(i))){
                    return -1;
                }
            }
            if (o1.length()>o2.length()){
                return 1;
            }else if (o1.length()<o2.length()) {
                return -1;
            }else return 0;
        });
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }

    }
}
