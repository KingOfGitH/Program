package cn.edu.leetcode.tencent;

import java.util.Arrays;
import java.util.Scanner;

public class 第五题 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        int k=scanner.nextInt();
        int ab[][]=new int[t][2];
        int kab[]=new int[t];
        for (int i = 0; i < t; i++) {
            ab[i][0]=scanner.nextInt();
            ab[i][1]=scanner.nextInt();
            kab[i]=ab[i][1]/k;
        }
        scanner.close();

        int max=0;
        for (int i = 0; i < t; i++) {
            if (max<ab[i][1]) max=ab[i][1];
        }
        int[] tmp=new int[max];
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < max/k; j++) {
                tmp[i]+=cmn(j-k*i+i,j);
            }
        }
        int res[]=new int[t];
        for (int i = 0; i < t; i++) {
            for (int j = ab[i][0]; j <= ab[i][1]; j++) {
                for (int l = 0; l <= kab[i]; l++) {
                    if (l*k>j) break;
                    res[i]+=cmn(j-k*l+l,l);
                }
            }
        }
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
    static int jieCheng(int m, int n){
        int sum=1;
        for (int j = m; j >m-n; j--) {
            sum*=j;
        }
        return sum;
    }
    static int cmn(int m, int n){
        n=Math.min(n,m-n);
        return jieCheng(m,n)/jieCheng(n,n);
    }
}
