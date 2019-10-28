package cn.edu.leetcode.tencent;

import java.util.Scanner;

import static sun.swing.MenuItemLayoutHelper.max;

public class 最大差异值 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] nums=new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=scanner.nextInt();
        }
        int[][] arr=new int[n][2];
        int j=0;
        while (scanner.hasNextInt()){
            arr[j][0]=scanner.nextInt();
            arr[j][1]=scanner.nextInt();
            j++;
        }
        int[][] b=new int[n][n];
        for (int i = 0; i < j; i++) {
            if (arr[i][0]==arr[i][1])break;
            b[arr[i][0]][arr[j][1]]=1;
            b[arr[i][1]][arr[j][0]]=1;
        }
        TreeNode head=generateTree(n, nums, b,0);
        scanner.close();
    }

    private static TreeNode generateTree(int n, int[] nums, int[][] b,int m) {
        TreeNode head=new TreeNode(nums[m]);
        for (int i = 0; i < n; i++) {
            if (b[m][i]==1){
                b[m][i]=0;
                b[i][m]=0;
                if (head.left!=null) {
                    head.left= generateTree(n,nums,b,i);
                }
                else head.right=generateTree(n,nums,b,i);
            }
        }
        return head;
    }
    private static int countTree(TreeNode head){
        if (head.left==null&&head.right==null) return head.val;
        if (head.left==null){
            return max(head.val,countTree(head.right));
        }
        if (head.right==null){
            return max(head.val,countTree(head.left));
        }
        return max(Math.abs(head.left.val-head.right.val),countTree(head.left)+countTree(head.right));
    }

}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val=val;
    }
}
