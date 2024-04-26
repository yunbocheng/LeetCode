package com.example.sort;

import java.util.Arrays;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-04-19
 */

/*
* 使用冒泡排序完成排序
*
* [1, 11, 8, 1, 5, 9, 4]
* */
public class 冒泡排序 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 11, 8, 1, 5, 9, 4};
//        int[] sortAsc = bubbleSortAsc(nums);
//        System.out.println(Arrays.toString(sortAsc));

        int[] sortDesc = bubbleSortDesc(nums);
        System.out.println(Arrays.toString(sortDesc));
    }

    /*
    * 升序
    * */
    public static int[] bubbleSortAsc(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        int size = nums.length - 1;
        for (int i = 0; i < size ; i++) {
            boolean flag = false;
            for (int j = 0; j < size - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    flag = true;
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
            if (!flag) {
                break;
            }
        }
        return nums;
    }


    public static int[] bubbleSortDesc(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        int size = nums.length - 1;
        for (int i = size; true; i--) {
            boolean flag = false;
            for (int j = size; j > size - i; j--) {
                if (nums[j] > nums[j-1]) {
                    flag = true;
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                }
            }
            if (!flag) {
                break;
            }
        }
        return nums;
    }

}
