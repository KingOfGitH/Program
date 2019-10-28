package sort;

import java.util.Arrays;

public class 冒泡排序 {
    public static void main(String[] args) {
        int[] arr={8,-1,9,7,5,2,3,4,8,5,10};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        int tmp;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length-i; j++) {
                if (arr[j-1]>arr[j]){
                    tmp=arr[j-1];
                    arr[j-1]=arr[j];
                    arr[j]=tmp;
                }
            }
        }
    }
}
