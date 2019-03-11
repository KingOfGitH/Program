package cn.dhu.sort;

public class Sort {
    public Sort() {
    }
    /**冒泡排序算法，从后往前依次进行n,n-1,,,1次循环**/
    public int[] MaoPaoSort(int[] nums){//稳定的排序算法
        int temp;
        for (int i=0;i<nums.length-1;i++) {
            for (int j=0;j<nums.length-1-i;j++){
                if(nums[j]>nums[j+1]){
                    temp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                }
            }
        }
        return nums;
    }
    /**选择排序，每一次循环选出最大或最小的位置，与当前循环位置交换**/
    public int[] ChooseSort(int[] nums){//不稳定的排序算法
        for (int i=0;i<nums.length-1;i++) {
            int temp=i;
            for (int j=i;j<nums.length-1;j++){
                if(nums[temp]>nums[j+1]){
                    temp=j+1;
                }
                if(temp!=i) {
                    nums[i] = nums[i] + nums[temp] - (nums[temp] = nums[i]);//两数交换新的交换思想
                }
            }
        }
        return nums;
    }
    /**直接插入排序 从后往前插入，设置标记**/
    public int[] InsertSort(int[] nums)//应该是稳定的
    {
        for (int i=1;i<nums.length;i++) {
            int temp=nums[i];
            int j;
            for (j=i-1;j>=0;j--) {
                if(nums[j]>temp)
                {
                    nums[j+1]=nums[j];
                }
                else {
                    break;
                }
            }
            if (nums[j+1]!=temp)nums[j+1]=temp;
        }
        return nums;
    }
}

