package com.example.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-04-22
 */
public class BM53缺失的第一个正整数 {


    public static void main(String[] args) {
        int[] nums = new int[]{1,0,2,-1,5,3};
        System.out.println(minNumberDisappeared(nums));
    }

    public static int minNumberDisappeared (int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // 去除负数和0
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                list.add(nums[i]);
            }
        }
        // 排序
        Collections.sort(list);
        // 进行比较，找出失去的最小的正整数
        int res = -1;
        for(int i = 0; i < list.size(); i++ ) {
            if (i+1 != list.get(i)) {
                res = i + 1;
                break;
            }
        }
        if (res == -1) {
            res = list.size() + 1;
        }
        return res;
    }

}
