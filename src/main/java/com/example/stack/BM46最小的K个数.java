package com.example.stack;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-05-08
 */
public class BM46最小的K个数 {

    public static void main(String[] args) {
        int[] input = new int[]{4,5,1,6,2,7,3,8};
        ArrayList<Integer> integers = GetLeastNumbers_Solution(input, 4);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }

    public static ArrayList<Integer> GetLeastNumbers_Solution (int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int j : input) {
            list.add(j);
        }
        // 排序
        Collections.sort(list);
        // 截取后边的k个元素
        ArrayList<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < k; i++) {
            res.add(list.get(i));
        }
        return res;
    }

}
