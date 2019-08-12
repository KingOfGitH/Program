package cn.edu.third;

import java.util.Arrays;

public class _5QuickSort {
    public static void main(String[] args) {
        int[] a={2, 1};
        quickSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
    static void quickSort(int[] A,int p,int r){
        if (p<r){
            int q=huaFen(A,p,r);
            quickSort(A,p,q-1);
            quickSort(A,q+1,r);
        }
    }

    private static int huaFen(int[] A, int p, int r) {
        int flag=A[p];
        int sp=p+1;
        int end=r;
        while (sp<=end){
            if(A[sp]<=flag) sp++;
            else {
                swap(A,sp,end);
                end--;
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
