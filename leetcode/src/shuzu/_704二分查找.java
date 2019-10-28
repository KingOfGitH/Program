package shuzu;

/**
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
 * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 */
public class _704二分查找 {
    public static void main(String[] args) {
        System.out.println(new _704二分查找().search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
    }
    public int search(int[] nums, int target) {
        int start=0;
        int end=nums.length-1;
        int mid;
        while (start<=end){
            mid=start+((end-start)>>1);
            if (nums[mid]==target) return mid;
            else if (nums[mid]>target) end=mid-1;
            else start=mid+1;
        }
        return -1;
    }
}
