package cn.edu.second;

import java.util.Arrays;
import java.util.Scanner;

public class 二进制数解密 {
    public static void main(String[] args) {

//        Scanner scanner = new Scanner(System.in);
//        int N=scanner.nextInt();
//        int K=scanner.nextInt();
//        String s=scanner.next();
        int N=7;
        int K=4;
        String s="1110100110";
        System.out.println(N+" "+K+" "+s);
        System.out.println(decode(N,K,s));
    }
    static String decode(int N,int K,String S){
        int[] a=new int[N];//输出结果 源码
        a[0]= S.charAt(0)-'0';
        int tmp=a[0];
        for (int i = 1; i < Math.min(N,K); i++) {
            a[i]= (S.charAt(i-1)-'0')^ (S.charAt(i)-'0');
            tmp=tmp^a[i];
        }
        if (N>K){
            for (int i = K; i < N; i++) {
                tmp=tmp^a[i-K];
                a[i]=tmp^(S.charAt(i)-'0');
                tmp=tmp^a[i];
            }
        }
        return Arrays.toString(a);
    }
}
