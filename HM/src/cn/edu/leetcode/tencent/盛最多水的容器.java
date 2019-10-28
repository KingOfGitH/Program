package cn.edu.leetcode.tencent;

public class 盛最多水的容器 {

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
    public static int maxArea(int[] height) {

        return maxArea(height,0,height.length-1,0,1);
    }

    public static int maxArea(int[] height,int start,int end,int max,int count) {
        int a=0,b=0;
        for (int i = start; i <= end; i++) {
            if (height[i]>0){
                start=i;
                a++;
                break;
            }
        }
        for (int i = end; i >= start; i--) {
            if (height[i]>0){
                end=i;
                b++;
                break;
            }
        }
        if (start>=end||a==0&&b==0) return max;
        int sum=(end-start)*count;
        if (sum>max) max=sum;
        for (int i = start; i <=end; i++) {
            height[i]--;
        }
        count++;
        return maxArea(height,start,end,max,count);
    }
}
