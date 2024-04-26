package com.example.sort;

import java.util.Arrays;

/**
 * @author : YunboCheng
 * @date : 22:20 2024/4/19
 */


/*
*
* 选择排序：每次寻找出最小的放在一边
*
* */
public class 选择排序 {

    public static void main(String[] args) {
        int[] nums = new int[]{4,11,1,3,8,15,3,2,11,-1};
        selectSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void selectSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            int min = i;
            for (int j = i + 1; j < size; j++) {
                min = nums[j] < nums[min] ? j : min;
            }
            int temp = nums[i];
            nums[i] = nums[min];
            nums[min] = temp;
        }
    }

}
