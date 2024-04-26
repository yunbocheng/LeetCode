package com.example.plan;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-04-24
 */
public class BM68矩阵的最小路径和 {

    public static void main(String[] args) {
        // 构建一个矩阵，也就是二位数组 [行][列]
        int[][] matrix = new int[4][4];

        // 第一行
        matrix[0][0] = 1;
        matrix[0][1] = 3;
        matrix[0][2] = 5;
        matrix[0][3] = 9;

        // 第二行
        matrix[1][0] = 8;
        matrix[1][1] = 1;
        matrix[1][2] = 3;
        matrix[1][3] = 4;

        // 第三行
        matrix[2][0] = 5;
        matrix[2][1] = 0;
        matrix[2][2] = 6;
        matrix[2][3] = 1;

        // 第四行
        matrix[3][0] = 8;
        matrix[3][1] = 8;
        matrix[3][2] = 4;
        matrix[3][3] = 0;

        int i = minPathSum(matrix);
        System.out.println(i);
    }


    public static int minPathSum(int[][] matrix) {
        // 计算矩阵的行和列数（直接使用 length 获取到的是矩阵的行数 ）
        int n = matrix.length;
        int m = matrix[0].length;

        // 定义二维数组，存储计算完的二位数组
        int[][] dp = new int[n+1][m+1];

        // 将整个矩阵分为四块计算 起点位置 第一列 第一行 其他行
        // 头部的数据和原数组的头节点一定是相等的
        dp[0][0] = matrix[0][0];

        // 处理第一列
        for (int i = 1 ; i < n; i++) {
            dp[i][0] = matrix[i][0] + dp[i-1][0];
        }

        // 处理第一行
        for (int j = 1; j < m; j++) {
            dp[0][j] = matrix[0][j] + dp[0][j-1];
        }

        // 处理其他行
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j]) + matrix[i][j];
            }
        }
        return dp[n-1][m-1];
    }

}
