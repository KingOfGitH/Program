package cn.edu;

import java.util.Scanner;

public class 豆油瓶 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int N=scanner.nextInt();
        int arr[][]=new int[N][N];
        int flag[]=new int[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j]=scanner.nextInt();
            }
        }
        int count=0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if ((flag[i]==0||flag[j]==0)&&arr[i][j]>=3){
                    count++;
                    find(arr,flag,i,j);
                }
            }
        }
        for (int i = 0; i < N; i++) {
            if (flag[i]==0){
                flag[i]=1;
                count++;
            }
        }
        System.out.println(count);
        scanner.close();
    }

    private static void find(int[][] arr, int[] flag, int i, int j) {
        if ((flag[i]==0||flag[j]==0)&&arr[i][j]>=3){
            flag[i]=1;
            flag[j]=1;
            for (int k = 0; k < arr.length; k++) {
                find(arr,flag,k,i);
                find(arr,flag,k,j);
            }
        }
    }
}
