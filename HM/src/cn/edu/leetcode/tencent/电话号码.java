package cn.edu.leetcode.tencent;

import java.util.Arrays;
import java.util.Scanner;

public class 电话号码 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int[] n=new int[t];
        String[] strings=new String[t];
        for (int i = 0; i < t; i++) {
            n[i] = scanner.nextInt();
            strings[i]=scanner.next();
        }
        for (int i = 0; i < t; i++) {
            if (n[i]<11) strings[i]="NO";
            else {
                for (int j = 0; j < n[i]-10; j++) {
                    if (strings[i].charAt(j)=='8'){
                        strings[i]="YES";
                        break;
                    }
                }
                if (!strings[i].equals("YES")) strings[i]="NO";
            }
        }
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
