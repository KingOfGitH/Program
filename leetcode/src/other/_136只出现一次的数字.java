package other;

public class _136只出现一次的数字 {
    public int singleNumber(int[] nums) {
        int x=nums[0];
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            x=x^nums[i];
        }
        return x;
    }
}
