package com.example.arr;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-05-06
 */
public class BM99顺时针旋转矩阵 {

    public static void main(String[] args) {
        int[][] mat = new int[3][3];
        mat[0][0] = 1;
        mat[0][1] = 2;
        mat[0][2] = 3;

        mat[1][0] = 4;
        mat[1][1] = 5;
        mat[1][2] = 6;

        mat[2][0] = 7;
        mat[2][1] = 8;
        mat[2][2] = 9;

        int[][] ints = rotateMatrix(mat, 3);
        for (int[] anInt : ints) {
            for (int i : anInt) {
                System.out.println(i);
            }
        }
    }

    public static int[][] rotateMatrix (int[][] mat, int n) {
        if (mat.length == 0 || n == 0) {
            return new int[0][0];
        }
        // 将矩阵先按照对角线进行交换
        int length = mat.length;
        for(int i = 0; i < length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
        // 将矩阵每行进行翻转
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length/2; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[i][length-j-1];
                mat[i][length-j-1] = temp;
            }
        }
        return mat;
    }

}
