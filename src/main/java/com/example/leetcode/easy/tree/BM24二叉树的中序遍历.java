package com.example.leetcode.easy.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-04-22
 */
public class BM24二叉树的中序遍历 {

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
        treeNode.left.right = new TreeNode(3);
        int[] ints = inorderTraversal(treeNode);
        System.out.println(Arrays.toString(ints));
    }

    /*
    * 递归遍历树节点方法(中序)
    * */
    public static void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        //递归遍历左节点
        inorder(root.left, list);
        //添加根节点
        list.add(root.val);
        //递归遍历右边节点
        inorder(root.right, list);
    }


    /*
    * 后续
    * */
    public static int[] inorderTraversal (TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        //存储结果
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

}
