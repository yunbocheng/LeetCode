package com.example.leetcode.easy.plan;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-04-24
 */
public class BM67不同路径的数目1 {

    public static void main(String[] args) {
        int m = 2;
        int n = 3;
        int i = uniquePaths(2, 3);
        System.out.println(i);
    }

    public static int uniquePaths (int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        //使用递归去计算
        return uniquePaths(m-1,n) + uniquePaths(m,n-1);
    }

}
