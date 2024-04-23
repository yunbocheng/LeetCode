package com.example.leetcode.easy.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-04-22
 */
public class BM25二叉树的后序遍历 {

    public static class TreeNode{
        private int val;

        private TreeNode left;

        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TreeNode treeNode = (TreeNode) o;
            return val == treeNode.val && Objects.equals(left, treeNode.left) && Objects.equals(right, treeNode.right);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, left, right);
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.left.right = new TreeNode(3);
        int[] ints = postorderTraversal(treeNode);
        System.out.println(Arrays.toString(ints));
    }

    /*
    * 递归遍历树节点方法(后序)
    * */
    public static void postorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        // 左节点
        postorder(root.left, list);
        // 右节点
        postorder(root.right, list);
        // 根节点
        list.add(root.val);
    }

    public static int[] postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorder(root, list);
        //返回数据
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

}
