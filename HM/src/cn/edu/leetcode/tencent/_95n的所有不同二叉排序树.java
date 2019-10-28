package cn.edu.leetcode.tencent;

import java.util.*;

public class _95n的所有不同二叉排序树 {
    public static void main(String[] args) {

    }
    public List<TreeNode> generateTrees(int n) {

        if (n==0) return null;
        else return find(1,n);
    }
    public static LinkedList<TreeNode> find(int start,int end){
        LinkedList<TreeNode> list= new LinkedList<TreeNode>();
        if (start>end){
            list.add(null);
            return list;
        }
        for (int i = start; i <= end; i++) {
            LinkedList<TreeNode> leftTrees=find(start,i-1);
            LinkedList<TreeNode> rightTrees=find(i+1,end);
            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    TreeNode treeNode=new TreeNode(i);
                    treeNode.left=leftTree;
                    treeNode.right=rightTree;
                    list.add(treeNode);
                }
            }
        }
        return list;
    }
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
        }
    }
}
