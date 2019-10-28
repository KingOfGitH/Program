package cn.edu;

import java.util.Scanner;

public class 二项式 {
    public static void main(String[] args) {
        int n= new Scanner(System.in).nextInt();
        if (n<0) System.out.println(0);
        else {
            n = n + 1;
            long res = 1;
            System.out.print("1 ");
            long a = 0;
            long b = n;
            for (int i = 1; i < n; i++) {
                res = res * (--b)/(++a);
                System.out.print(res + " ");
            }
//        for (int i = n/2+1; i < n; i++) {
//
//        }
//        for (int re : res) {
//            System.out.print(re+" ");
//        }
            System.out.println();
        }
    }
}
