package com.example.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;

/**
 * LeetCode[1] : 两数之和
 */

// 示例 1：
//
//
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
//
//
// 示例 2：
//
//
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
//
//
// 示例 3：
//
//
//输入：nums = [3,3], target = 6
//输出：[0,1]

public class SumOfTwoNumbers {

    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        HashMap<Integer,Integer> numMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < len; i++) {
            if (numMap.containsKey(target - nums[i])) {
                return new int[]{numMap.get(target - nums[i]) , i};
            }
            numMap.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        SumOfTwoNumbers sumOfTwoNumbers = new SumOfTwoNumbers();
        System.out.println(Arrays.toString(sumOfTwoNumbers.twoSum(new int[]{3, 3}, 6)));
    }
}
