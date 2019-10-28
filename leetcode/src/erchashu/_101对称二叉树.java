package erchashu;

public class _101对称二叉树 {
    public boolean isSymmetric(TreeNode root) {
        if (root==null) return true;
        if (root.left==null&&root.right==null) return true;
        return isSymmetric(root.left,root.right);
    }
    public boolean isSymmetric(TreeNode l,TreeNode r) {
        if (l==null&&r==null) return true;
        if (l == null) return false;
        if (r == null) return false;
        if(l.val==r.val){
            return isSymmetric(l.left,r.right)&&isSymmetric(l.right,r.left);
        }
        return false;
    }
}

