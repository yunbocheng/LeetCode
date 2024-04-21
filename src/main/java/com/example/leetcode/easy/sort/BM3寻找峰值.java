package com.example.leetcode.easy.sort;

/**
 * @author : YunboCheng
 * @date : 12:15 2024/4/20
 */

/*
*
* 寻找峰值
*
*
* [2,4,1,2,7,8,4]
* 8
* */
public class BM3寻找峰值 {

    public static void main(String[] args) {
        int[] nums = new int[]{2,4,1,2,7,8,4};
        int peakElement = findPeakElement(nums);
        System.out.println(peakElement);
    }

    public static int findPeakElement (int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] < nums[mid + 1]) {
                // 向上一定存在峰值
                low = mid + 1;
            }else {
                high = mid;
            }
        }
        return low;
    }
}
