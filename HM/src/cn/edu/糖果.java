package cn.edu;

import java.util.Arrays;
import java.util.Scanner;

public class 糖果 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int N=scanner.nextInt();
        int arr[]=new int[N];
        for (int i = 0; i < N; i++) {
            arr[i]=scanner.nextInt();
        }
        int flag[]=new int[N];
        int max=0;
        int count=1;
        int[][] b=new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                if (gcd(arr[i],arr[j])>1){
                    b[i][j]=1;
                }
            }
        }
        System.out.println(Arrays.deepToString(b));
        for (int i = 0; i < N; i++) {
            count=1;
            for (int j = i+1; j < N; j++) {
                count+=b[i][j];
            }
            if (max<count){
                max=count;
            }
        }
        System.out.println(max);
        scanner.close();
    }
    public static int gcd(int m,int n){
        return n == 0 ? m : gcd(n, m % n);
    }
}
