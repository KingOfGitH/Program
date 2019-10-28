package shuzu;

public class _238除自身以外数组的乘积 {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int res[]=new int[length];
        int left[]=new int[length];
        int right[]=new int[length];
        if (length <=1) return res;
        left[0]=nums[0];
        right[length-1]=nums[length-1];
        for (int i = 1; i < length; i++) {
            left[i]=left[i-1]*nums[i];
        }
        for (int i = length-2; i >= 0; i--) {
            right[i]= right[i+1]*nums[i];
        }
        res[0]=right[1];
        res[length-1]=left[length-2];
        for (int i = 1; i < length-1; i++) {
            res[i]=left[i-1]*right[i+1];
        }
        return res;
    }
}
