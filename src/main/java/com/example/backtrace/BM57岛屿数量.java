package com.example.backtrace;

import java.util.Objects;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-04-24
 */
public class BM57岛屿数量 {

    public static void main(String[] args) {
        // 构建一个岛屿，其中数据是字符换
        char[][] arr = new char[5][5];

        // 第一行
        arr[0][0] = '1';
        arr[0][1] = '1';
        arr[0][2] = '0';
        arr[0][3] = '0';
        arr[0][4] = '0';

        // 第二行
        arr[1][0] = '0';
        arr[1][1] = '1';
        arr[1][2] = '0';
        arr[1][3] = '1';
        arr[1][4] = '1';

        // 第三行
        arr[2][0] = '0';
        arr[2][1] = '0';
        arr[2][2] = '0';
        arr[2][3] = '1';
        arr[2][4] = '1';

        // 第四行
        arr[3][0] = '0';
        arr[3][1] = '0';
        arr[3][2] = '0';
        arr[3][3] = '0';
        arr[3][4] = '0';

        // 第五行
        arr[4][0] = '0';
        arr[4][1] = '0';
        arr[4][2] = '1';
        arr[4][3] = '1';
        arr[4][4] = '1';

        int solve = solve(arr);
        System.out.println(solve);
    }

    /*
    * 计算岛屿的数量
    * */
    public static int solve (char[][] grid) {
        // 排除边界条件
        if (grid == null || grid.length == 0) {
            return 0;
        }

        // 统计岛屿总数量
        int count = 0;
        // 循环遍历每个岛屿
        // 每行
        for (int i = 0; i < grid.length; i++) {
            // 每行中的每列
            for (int j = 0; j < grid[0].length; j++) {
                // 只有当前格子是"1"的时候才进行统计
                if (grid[i][j] == '1') {
                    // 累加岛屿数量
                    count++;
                    // 将该格子上下左右的格子为'1'都改为'0'，因为相连在一起的 '1' 的格子构成一个岛屿
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    public static void dfs(char[][] grid, int i, int j) {
        /*
        * 1. 当格子值为 '0'
        * 2. 当i的值小于0，行的左边越界，出grid了
        * 3. 当i的值大于等于 grid.length 时，行的右边月结，出grid了
        * 4. 当j的值小于0，列的上边越界，出grid了
        * 5. 当j的值大于等于 grid[0].length 时，列的下边越界，出grid了
        * */
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        // 将当前格子的值置为 '0'
        grid[i][j] = '0';
        // 将该格子的上下左右存在'1'的都置为'0'，使用递归，将下边所有'1'连接的都置为'0'
        dfs(grid, i - 1, j); // 上
        dfs(grid, i + 1, j); // 下
        dfs(grid, i, j - 1); // 左
        dfs(grid, i, j + 1); // 右
    }

}
