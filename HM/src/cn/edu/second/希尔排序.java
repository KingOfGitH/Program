package cn.edu.second;

import java.util.Arrays;

public class 希尔排序 {
    public static void main(String[] args) {
        int[] arr={9,8,7,5,7,3,2,1};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void shellSort(int[] arr){
        //interval不断缩小增量
        for (int interval = arr.length/2; interval > 0; interval/=2) {
            for (int i = 0; i < arr.length; i++) {
                int target = arr[i];
                int j=i-interval;
                while (j>-1&&target<arr[j]){
                    arr[j+interval]=arr[j];
                    j-=interval;
                }
                arr[j+interval]=target;
            }
        }
    }
}
