package cn.dhu.sort;

public class SortMain {
    public static void main(String[] args) {
        int[] nums={9,6,5,3,15,65,2,3,0};
        int[] numsSort= new Sort().InsertSort(nums);
        for (int i=0;i<numsSort.length;i++){
            System.out.println(numsSort[i]);
        }
    }
}