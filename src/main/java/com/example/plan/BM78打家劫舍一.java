package com.example.plan;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-04-24
 */
public class BM78打家劫舍一 {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4};
        System.out.println(rob(arr));
    }


    public static int rob (int[] nums) {
        //排除错误值
        int l = nums.length;
        if (l == 0) {
            return 0;
        }
        if (l == 1) {
            return nums[0];
        }

        //定义存储打劫总数的数组
        int[] dp = new int[l];
        //当只存在一家时，只能打劫第一家
        dp[0] = nums[0];
        //当存在两家时，就要比较哪家钱多，打劫哪家
        dp[1] = Math.max(nums[0], nums[1]);
        //剩下的就按照规则计算，要不打劫1和3家，要不打击第二家
        for(int i = 2; i < l; i++) {
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }
        return dp[l-1];
    }

}
