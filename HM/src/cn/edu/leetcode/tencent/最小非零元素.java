package cn.edu.leetcode.tencent;

import java.util.Arrays;
import java.util.Scanner;

public class 最小非零元素 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int k=scanner.nextInt();
        int[] nums=new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=scanner.nextInt();
        }
        Arrays.sort(nums);
        int target=0;
        int[] res=new int[k];
        int index=0;
        int indexK=0;
        while (index<n&&indexK<k){
            if (nums[index]-target<=0) index++;
            else {
                res[indexK]=nums[index]-target;
                target=nums[index];
                indexK++;
                index++;
            }
        }
        for (int re : res) {
            System.out.println(re);
        }
    }
}
