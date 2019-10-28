package sort;

import java.util.Arrays;

public class 希尔排序 {
    public static void main(String[] args) {
        int[] arr={8,-1,15,7,5,2,3,4,8,5,10};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int[] arr){
        int k=arr.length/2;
        int minIndex;
        int tmp;
        while (k>0){
            for (int i = 0; i < arr.length; i++) {
                minIndex=i;
                for (int j = i+k; j < arr.length; j+=k) {
                    if (arr[minIndex]>arr[j]) minIndex=j;
                }
                tmp=arr[i];
                arr[i]=arr[minIndex];
                arr[minIndex]=tmp;
            }

            k/=2;
        }
    }
}
