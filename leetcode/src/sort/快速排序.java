package sort;

import java.util.Arrays;

public class 快速排序 {
    public static void main(String[] args) {
        int[] arr={8,-1,9,7,18,3,0,9,6,2,1,-3};
        sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int[] arr,int p,int r){
        if (p<r){
            int q=huaFen(arr,p,r);
            sort(arr,p,q-1);
            sort(arr,q+1,r);
        }
    }

    private static int huaFen(int[] arr, int p, int r) {
        int res=arr[p];
        int start=p;
        p++;
        while (p<=r){
            while (p<=r&&arr[p]<=res)p++;
            while (p<=r&&arr[r]>res)r--;
            if (p<=r){
                swap(arr,p,r);
            }
        }
        swap(arr,start,r);
        return r;
    }

    private static void swap(int[] arr, int p, int r) {
        if (p==r) return;
        arr[p]=arr[p]-arr[r];
        arr[r]=arr[r]+arr[p];
        arr[p]=arr[r]-arr[p];
    }
}
