package cn.edu.leetcode.tencent;

import java.util.Arrays;

import static sun.swing.MenuItemLayoutHelper.max;

public class 删除排序数组中的重复项 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int i=0,j=0;
        if (nums.length<=0)return 0;
        if (nums.length==1)return 1;
        for (i = 0; i < nums.length-1; i++) {
            if (nums[i]!=nums[i+1]){
                nums[j]=nums[i];
                j++;
            }
        }
        if (nums[Math.max(j-1,0)]!=nums[i]){
            nums[j]=nums[i];
            j++;
        }
        System.out.println(Arrays.toString(nums));
        return Math.max(j,1);
    }
}
