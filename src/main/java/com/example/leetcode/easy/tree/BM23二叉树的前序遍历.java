package com.example.leetcode.easy.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-04-22
 */
public class BM23二叉树的前序遍历 {

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
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);
        int[] arr = preorderTraversal(treeNode);
        System.out.println(Arrays.toString(arr));
    }

    /*
    * 递归遍历树节点方法(前序)
    * */
    public static void preorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        //添加根节点
        list.add(root.val);
        //递归遍历左节点
        preorder(root.left, list);
        //递归调用右节点
        preorder(root.right, list);
    }


    /*
    * 前序遍历
    *
    * */
    public static int[] preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        // 递归调用，获树节点信息
        preorder(root, list);
        // 返回结果
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
