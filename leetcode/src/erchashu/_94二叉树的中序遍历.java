package erchashu;

import java.util.ArrayList;
import java.util.List;

public class _94二叉树的中序遍历 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        if (root==null) return list;
        if (root.left!=null) list.addAll(inorderTraversal(root.left));
        list.add(root.val);
        if (root.right!=null) list.addAll(inorderTraversal(root.right));
        return list;
    }

}
