package com.example.greedy;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-04-24
 */
public class BM96主持人调度 {

    public static void main(String[] args) {
        int[][] arr = new int[2][2];
        arr[0][0] = 1; // 开始时间
        arr[0][1] = 3; // 结束时间
        arr[1][0] = 2; // 开始时间
        arr[1][1] = 5; // 结束时间
        int n = 2;
        int i = minmumNumberOfHost(n, arr);
        System.out.println(i);

    }

    public static int minmumNumberOfHost (int n, int[][] startEnd) {
        if (startEnd == null || startEnd.length == 0) {
            return 0;
        }
        if (n == 0) {
            return 0;
        }
        // 将开始时间和结束时间分别存储并排序
        int[] start = new int[startEnd.length];
        // 注意这个地方，可不是存储的列宽，也是行宽，因为存储结束时间
        //int[] end = new int[startEnd[0].length];
        int[] end = new int[startEnd.length];

        // 循环存储
        // 存储开始时间和结束时间
        for (int i = 0; i < startEnd.length; i++) {
            // 他是一个 n * 2 的矩阵
            start[i] = startEnd[i][0];
            end[i] = startEnd[i][1];
        }

        // 将时间按照顺序排序
        Arrays.sort(start);
        Arrays.sort(end);

        // 循环遍历，如果 开始时间小于结束时间 ，则需要添加主持人，否则将结束时间向后移动
        int res = 0; // 主持人数量
        int j = 0; // 结束时间下标
        for (int i = 0; i < n; i++) {
            if (start[i] < end[j]) {
                // 如果存在开始时间小于等于结束时间的话，那么就需要添加一个主持人
                res++;
            }else {
                // 时间正常，向后推动结束时间
                j++;
            }
        }
        return res;
    }


}
