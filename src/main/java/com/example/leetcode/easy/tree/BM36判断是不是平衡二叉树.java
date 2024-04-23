package com.example.leetcode.easy.tree;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-04-22
 */
public class BM36判断是不是平衡二叉树 {

    private static class TreeNode{
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(8);
        treeNode.left = new TreeNode(6);
        treeNode.right = new TreeNode(10);
        treeNode.left.left = new TreeNode(5);
        treeNode.left.right = new TreeNode(7);
        treeNode.right.left = new TreeNode(9);
        treeNode.right.right = new TreeNode(11);
    }

    //计算该子树深度函数
    public int deep(TreeNode pRoot){
        //空节点深度为0
        if(pRoot == null)
            return 0;
        //递归算左右子树的深度
        int left = deep(pRoot.left);
        int right = deep(pRoot.right);
        //子树最大深度加上自己
        return (left > right) ? left + 1 : right + 1;
    }


    /*
    * 判断是不是平衡二叉树
    * 平衡二叉树任意节点两边的子树深度相差绝对值不会超过1
    * */
    public boolean IsBalanced_Solution (TreeNode pRoot) {
        //空树为平衡二叉树
        if (pRoot == null)
            return true;
        int left = deep(pRoot.left);
        int right = deep(pRoot.right);
        //左子树深度减去右子树相差绝对值大于1
        if(left - right > 1 || left - right < -1)
            return false;
        //同时，左右子树还必须是平衡的
        return IsBalanced_Solution(pRoot.left) && IsBalanced_Solution(pRoot.right);
    }
}
