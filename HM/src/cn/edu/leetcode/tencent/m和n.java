package cn.edu.leetcode.tencent;

import java.util.Arrays;
import java.util.Scanner;

public class m和n {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int m=scanner.nextInt();
        int n=scanner.nextInt();
        int k=scanner.nextInt();
        scanner.close();
        int[] arr=new int[n*m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i*m+j]=(i+1)*(j+1);
            }
        }


        System.out.println(quickSort(arr,0,arr.length-1,m*n-k));
    }
    static int quickSort(int[] A,int p,int r,int k){
        if (p<r){
            int q=huaFenDouble(A,p,r);
            if (q<k){
                quickSort(A,q+1,r,k);
            }else if (q>k){
                quickSort(A,p,q-1,k);
            }else {
                return A[k];
            }
        }
        return A[k];
    }
    private static int huaFenDouble(int[] A, int p, int r) {
        int flag=A[p];
        int sp=p+1;
        int end=r;
        while (sp<=end){
            while (sp<=end&&A[sp]<=flag) sp++;
            while (sp<=end&&A[end]>flag) end--;
            if (sp<=end){
                swap(A,sp,end);
            }
        }
        swap(A, p, end);
        return end;
    }
    private static void swap(int[] A, int p, int end) {
        if (A[p]==A[end])return;
        A[end]=A[end]^A[p];
        A[p]=A[end]^A[p];
        A[end]=A[end]^A[p];
    }
}
