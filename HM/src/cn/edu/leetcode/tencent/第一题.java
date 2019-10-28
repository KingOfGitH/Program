package cn.edu.leetcode.tencent;


import java.util.Scanner;

public class 第一题 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        int[] box=new int[n];
        int box0=0;
        int box1=0;
        int[] lock=new int[m];
        int lock0=0;
        int lock1=0;
        for (int i = 0; i < n; i++) {
            box[i]=scanner.nextInt();
            if(box[i]%2==0) box0++;
            else box1++;
        }
        for (int i = 0; i < m; i++) {
            lock[i]=scanner.nextInt();
            if(lock[i]%2==0) lock0++;
            else lock1++;
        }
        scanner.close();
        int res=Math.min(box0,lock1)+Math.min(box1,lock0);
        System.out.println(res);
    }
}
