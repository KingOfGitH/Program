package cn.edu.wangyi;


import java.math.BigDecimal;
import java.util.Scanner;


public class 第一题 {
    public static long gcd(long m,long n){
        return n == 0 ? m : gcd(n, m % n);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long m=scanner.nextLong();
        long n=scanner.nextLong();
        long max=gcd(m,n);
        BigDecimal a=new BigDecimal(m/max);
        BigDecimal b=new BigDecimal(n);
        BigDecimal min = a.multiply(b);
        System.out.println(max+" "+min);
    }
}
