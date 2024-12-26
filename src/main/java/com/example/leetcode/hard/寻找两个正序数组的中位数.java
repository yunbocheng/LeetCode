package com.example.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author chengyunbo03@gyyx.cn
 * @since 2024-12-25 11:02
 */

public class 寻找两个正序数组的中位数 {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2};
        int[] nums2 = new int[]{3,4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            res.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            res.add(nums2[i]);
        }
        // 对 res 集合进行排序
        Collections.sort(res);

        int size = res.size();
        int middle = size / 2;

        if (size % 2 != 0) {
            return res.get(middle);
        }else {
            return (double) (res.get(middle - 1) + res.get(middle)) / 2;
        }
    }

}
