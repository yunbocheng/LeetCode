package com.example.sort;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-04-30
 */
public class BM20数组中的逆序对 {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,0};
        System.out.println(InversePairs(arr));
    }

    public static int InversePairs (int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 注意：这个结果使用long类型，防止数据大小超过int范围，和1000000007取模之后在转换为int类型
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    res++;
                }
            }
        }
        return (int) (res % 1000000007);
    }

}
