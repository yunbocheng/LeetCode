package com.example.leetcode.easy.tree;

import java.util.Arrays;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-04-24
 */
public class BM70兑换零钱一 {


    public static void main(String[] args) {
        int[] arr = new int[]{5,2,3};
        int aim = 20;
        minMoney(arr, 20);
    }

    public static int minMoney (int[] arr, int aim) {
        //如何使用最少arr元素 构成 aim值
        //dp[i] 代表给定钱数为i的时候最少货币数 就是凑成 i 元钱，需要dp[i] 张arr中面值纸币
        //没办法兑换 arr[i]  dp[i] = dp[i]
        //可以dp[i] = dp[i - arr[i]] + 1
        //dp[i] = min(dp[i], dp[i-a[j]])
        if(arr == null || arr.length == 0){
            return -1;
        }
        int[] dp = new int[aim+1];
        for(int i = 0;i<=aim;i++){
            dp[i] = aim+1;
        }
        dp[0] = 0;
        for(int i = 1;i<=aim;i++){
            for(int j = 0;j< arr.length;j++){
                if(arr[j] <= i){
                    //给了一张 3 元钱，小于 需要找零的4 元钱，那 就等于 1 + 需要找零剩下的钱dp[i -arr[j]] 4 - 3
                    dp[i] = Math.min(dp[i], dp[i-arr[j]] +1);
                }
            }
        }
        return (dp[aim] > aim) ?-1 : dp[aim];
    }

}
