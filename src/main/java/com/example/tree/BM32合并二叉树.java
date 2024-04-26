package com.example.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-04-22
 */
public class BM32合并二叉树 {

    private static class TreeNode{
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        treeNode1.left  = new TreeNode(3);
        treeNode1.right = new TreeNode(2);
        treeNode1.left.left = new TreeNode(5);

        TreeNode treeNode2 = new TreeNode(2);
        treeNode2.left = new TreeNode(1);
        treeNode2.right = new TreeNode(3);
        treeNode2.left.right = new TreeNode(4);
        treeNode2.right.right = new TreeNode(7);
        TreeNode treeNode = mergeTrees(treeNode1, treeNode2);
        int[] ints = preorderTreeNode(treeNode);
        System.out.println(Arrays.toString(ints));
    }

    /*
    * 合并二叉树
    * */
    public static TreeNode mergeTrees (TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        // 创建新的树节点，计算完之后将其返回，和上一层进行拼接
        TreeNode head = new TreeNode(t1.val + t2.val);
        head.left = mergeTrees(t1.left, t2.left);
        head.right = mergeTrees(t1.right, t2.right);
        return head;
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
