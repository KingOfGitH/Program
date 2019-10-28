package sort;

import java.util.Arrays;

public class 插入排序 {
    public static void main(String[] args) {
        int[] arr={8,-1,9,7,5,2,3,4,8,5,10};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int[] arr){
        int tmp;
        for (int i = 0; i < arr.length; i++) {
            tmp=arr[i];
            for (int j = i-1; j >= 0; j--) {
                if (tmp<arr[j]){
                    arr[j+1]=arr[j];
                }else {
                    arr[j+1]=tmp;
                    break;
                }
            }
            if (tmp<arr[0]){
                arr[0]=tmp;
            }
        }
    }
}
