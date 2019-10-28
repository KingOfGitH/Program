package cn.edu.leetcode.tencent;

import java.util.Scanner;

public class 第三题 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        int nums[]=new int[n];
//        int sum[]=new int[n+1];
        int sum=0;
        for (int i = 0; i < n; i++) {
            nums[i]=scanner.nextInt();
//            sum[i+1]=nums[i]+sum[i];
            sum+=nums[i];
        }
        scanner.close();
        System.out.println(up(sum,m)+n);
    }
     static int up(int a, int b){
        return a%b==0?a/b:(a/b+1);
     }
}
