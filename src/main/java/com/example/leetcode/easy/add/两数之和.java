package com.example.leetcode.easy.add;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-04-22
 */

/*
* 输入：nums = [2,7,11,15], target = 9
输出：[0,1]
解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1]
*
* */
public class 两数之和 {

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        int[] ints = twoSum(nums, 13);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        /*
        * key存储元素的值，value存储元素的下标
        * num[0] + num[1] = 9 -》 9 = num[1] - num[0]
        * */
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0 ; i < nums.length; i++ ) {
            if (map.containsKey(target-nums[i])) {
                return new int[]{map.get(target-nums[i]), i};
            }else {
                map.put(nums[i], i);
            }
        }
        return new int[]{0};
    }
}
