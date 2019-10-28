package sort;

import java.util.Arrays;

public class 归并排序 {
    public static void main(String[] args) {
        int[] arr={8,-1,9,7,18,3,0,9,6,2,1,-3};
        sort(arr,0,arr.length);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int[] arr,int p,int r){
        int length = (r-p)/2;
        if (length>=2){
            int m=length/2;
            sort(arr,p,m);
            sort(arr,m,r);
            int s=p,e=m;
            while (s<p+m&&e<p+length){
            }
        }
    }
}
