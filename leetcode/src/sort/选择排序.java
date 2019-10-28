package sort;

import java.util.Arrays;

public class 选择排序 {
    public static void main(String[] args) {
        int[] arr={8,-1,9,7,5,2,3,4,8,5,10};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int[] arr){
        int minIndex;
        int tmp;
        for (int i = 0; i < arr.length-1; i++) {
            minIndex=i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[minIndex]>arr[j]) minIndex=j;
            }
            tmp=arr[i];
            arr[i]=arr[minIndex];
            arr[minIndex]=tmp;
        }
    }
}
