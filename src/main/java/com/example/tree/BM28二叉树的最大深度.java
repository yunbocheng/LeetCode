package com.example.tree;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-04-22
 */
public class BM28二叉树的最大深度 {

    public static class TreeNode{

        private int val;

        private TreeNode left;

        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.right = new TreeNode(4);
        treeNode.right.right = new TreeNode(5);
        int i = maxDepth(treeNode);
        System.out.println(i);
    }


    /*
    * 使用递归计算出最大深度
    * */

    public static int maxDepth (TreeNode root) {
        //空节点没有深度
        if(root == null)
            return 0;
        //返回子树深度+1
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
