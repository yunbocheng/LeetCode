package com.example.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-04-22
 */
public class BM33二叉树的镜像 {

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
        TreeNode mirror = Mirror(treeNode);
        System.out.println(Arrays.toString(preorderTreeNode(mirror)));


    }

    /*
    * 二叉树镜像
    * */
    public static TreeNode Mirror (TreeNode pRoot) {
        if (pRoot == null) {
            return null;
        }
        // 先递归子树
        TreeNode right = Mirror(pRoot.right);
        TreeNode left = Mirror(pRoot.left);
        // 左右子节点交换
        pRoot.left = right;
        pRoot.right = left;
        return pRoot;
    }

    private static void preorder(TreeNode treeNode, List<Integer> list) {
        if (treeNode == null) {
            return;
        }
        // 使用前序遍历
        // 头
        list.add(treeNode.val);
        // 左
        preorder(treeNode.left, list);
        // 右
        preorder(treeNode.right, list);
    }

    private static int[] preorderTreeNode(TreeNode treeNode) {
        if (treeNode == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        preorder(treeNode, list);
        // 输出结果
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

}
