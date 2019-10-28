package cn.edu.leetcode.tencent;

import java.util.Arrays;
import java.util.Scanner;

public class 获胜方法 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] xi=new int[n];
        int baseSum=1;
        for (int i = 0; i < n; i++) {
            xi[i]=scanner.nextInt();
            baseSum*=xi[i];
        }
        int sum=0;
        boolean flag=true;
        int count;
        int xiangdeng;
        double res=0;
        while (flag){
            flag=false;
            count=0;
            xiangdeng=0;
            sum++;
            for (int i = 0; i < n; i++) {
                if (xi[i]<sum) count+=xi[i];
                else {
                    xiangdeng++;
                }
            }
            double v=0;
            for (int i = 0; i < xiangdeng; i++) {
                v+= cmn(xiangdeng, i + 1) * (count + (xiangdeng - i - 1)*(sum-1));
            }
            res+=count*1.0/baseSum*sum;
        }
        System.out.println(res);
        scanner.close();
    }
    static int jiecheng(int m, int n){
        int sum=1;
        for (int j = m; j >m-n; j--) {
            sum*=j;
        }
        return sum;
    }
    static double cmn(int m, int n){
        return jiecheng(m,n)*1.0/jiecheng(n,n);
    }
}
