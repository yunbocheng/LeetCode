package com.example.leetcode.easy.sort;

import java.util.Arrays;

/**
 * @author : YunboCheng
 * @date : 23:17 2024/4/19
 */

/*
*
* 插入排序：按照顺序一个个的获取然后放入到前边已经排序好的数组中
* */
public class 插入排序 {

    public static void main(String[] args) {
        int[] nums = new int[]{4,11,1,3,8,15,3,2,11,-1};
        insertSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void insertSort(int[] nums) {
        int size = nums.length;
        for (int i = 1; i < size; i++) {
            int end = i;
            while (end - 1 >=0 && nums[end] < nums[end-1]) {
                int temp = nums[end];
                nums[end] = nums[end-1];
                nums[end-1] = temp;
                end--;
            }
        }
    }

}
