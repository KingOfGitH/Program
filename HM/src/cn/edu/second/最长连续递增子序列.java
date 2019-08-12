package cn.edu.second;

import java.util.Arrays;

public class 最长连续递增子序列 {
    public static void main(String[] args) {
        int[] a={1,9,2,5,7,3,4,6,8,0};
        findLongestSubsequence(a);
    }

    public static void findLongestSubsequence(int[] a){
        int[] b=new int[a.length];
        int i=0;
        int j=0;
        for (i = 1; i < a.length; i++) {
            if (a[i-1]>a[i]){
                b[j++]=i;
            }
        }
        b[j++]=i;
        System.out.println(Arrays.toString(b));
        int max=b[0];
        int index=0;
        for (int k = 1; k < j; k++) {
            int tmp = b[k] - b[k - 1];
            if (tmp >max){
                max= tmp;
                index=k;
            }
        }

        for (int k = b[Math.max(index - 1, 0)]; k < b[index]; k++) {
            System.out.print(a[k]+" ");
        }
    }
}
