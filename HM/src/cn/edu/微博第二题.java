package cn.edu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.min;

public class 微博第二题 {
    public static void main(String[] args) {
        int a=6,b=2,c=2;
        int arr[]={4,1,2,3,1,2};
        int res[]=new int[c+1];
        int count=0;
        if (c+1>=a){
            Arrays.sort(arr);
            for (int i = arr.length - 1; i >= arr.length -b; i--) {
                count+=arr[i];
            }
            System.out.println(count);
            return;
        }
        b=min(b,c+1);
        for (int i = 0; i < a-c; i++) {
            for (int j = i; j < i+c+1; j++) {
                res[j-i]=arr[j];
            }
            Arrays.sort(res);
            int tmp=0;
            for (int j = res.length - 1; j >= res.length -b; j--) {
                tmp+=res[j];
            }

            if (tmp>count) count=tmp;
        }
        List<Integer> list=new ArrayList<>();
        System.out.println(count);
    }
    static int find(tmp[] arr, int b){
        int count=0;
        int[] res=new int[b];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < b; j++) {
                if (res[i]<res[j]){
                    swap(res,i,j);
                }
            }
        }
        return count;
    }
    private static void swap(int[] A, int p, int end) {
        if (A[p]==A[end])return;
        A[end]=A[end]^A[p];
        A[p]=A[end]^A[p];
        A[end]=A[end]^A[p];
    }
    class tmp{
        int num;
        int index;
    }
}
