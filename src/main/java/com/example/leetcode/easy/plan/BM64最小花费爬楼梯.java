package com.example.leetcode.easy.plan;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-04-24
 */
public class BM64最小花费爬楼梯 {

    public static void main(String[] args) {
        int[] arr = new int[]{2,5,20};
        int i = minCostClimbingStairs(arr);
        System.out.println(i);
    }

    /*
    * 爬楼梯花费最小
    * dp[i] = Math.min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2])
    * */
    public static int minCostClimbingStairs (int[] cost) {
        if (cost.length == 0) {
            return 0;
        }
        int[] dp = new int[cost.length + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2]);
        }
        return dp[cost.length];
    }

}
