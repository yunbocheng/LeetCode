package com.example.plan;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-04-24
 */
public class BM79打家劫舍二 {


    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        System.out.println(rob(nums));
    }

    public static int rob (int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int l = nums.length;
        // 分别计算
        // 假设可以打劫第一家，不能打劫最后一家
        int[] dp1 = new int[l];
        dp1[0] = 0;
        dp1[1] = nums[0];
        for (int i = 2; i < l; i++) {
            dp1[i] = Math.max(dp1[i-1], dp1[i-2] + nums[i-1]);
        }

        // 假设不能打劫第一家，能打劫最后一家
        int[] dp2 = new int[l];
        dp2[0] = 0;
        dp2[1] = nums[1];
        for (int i = 2; i < l; i++) {
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + nums[i]);
        }

        return Math.max(dp1[l-1], dp2[l-1]);
    }

}
