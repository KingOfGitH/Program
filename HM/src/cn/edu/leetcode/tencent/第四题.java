package cn.edu.leetcode.tencent;

import java.util.Scanner;

public class 第四题 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int nums[]=new int[n];
        int[] sum=new int[n+1];
        for (int i = 0; i < n; i++) {
            nums[i]=scanner.nextInt();
            sum[i+1]=nums[i]+sum[i];
        }
        scanner.close();
        int min;
        int minIndex;
        int res=0;
        int tmp;
        for (int i = 0; i < n; i++) {
            min=Integer.MAX_VALUE;
            minIndex=n;
            for (int j = i; j < n; j++) {
                if (min>nums[j]){
                    min=nums[j];
                    minIndex=j;
                }
                tmp = min * (sum[j + 1] - sum[i]);
                if(res< tmp){
                    res= tmp;
                }
            }
            i=minIndex;
        }
        System.out.println(res);
    }
}
