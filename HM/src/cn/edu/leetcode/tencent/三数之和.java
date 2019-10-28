package cn.edu.leetcode.tencent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 三数之和 {
    public static void main(String[] args) {
        int nums[]={-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums).toString());
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        int start=0;
        int end=nums.length-1;
        while (start+1<end){
            if (nums[start]>0||nums[end]<0) break;
            if (start==0||nums[start-1]!=nums[start]){
                if (nums[start]+nums[start+1]+nums[end]>0) {
                    end--;
                    continue;
                }
                else if (nums[start]+nums[end-1]+nums[end]<0) {
                    start++;
                    continue;
                }
                else {
                    for (int i = start+1; i < end-1; i++) {
                        if (nums[start]+nums[i]+nums[end]==0){
                            res.add(Arrays.asList(nums[start],nums[i],nums[end]));
                        }
                    }
                }
            }
            start++;
        }
        return res;
    }
}
