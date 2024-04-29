package com.example.string;

/**
 * @author : YunboCheng
 * @date : 23:35 2024/4/29
 */
public class BM93盛水最多的容器 {

    public static void main(String[] args) {
        int[] height = new int[]{1,7,3,2,4,5,8,2,7};
        int i = maxArea(height);
        System.out.println(i);
    }

    public static int maxArea (int[] height) {
        if (height == null || height.length < 1) {
            return 0;
        }
        //使用双指针
        int low = 0;
        int high = height.length - 1;
        int res = 0;
        while (low < high) {
            int capacity = Math.min(height[low], height[high]) * (high - low);
            res = Math.max(res, capacity);
            if (height[low] < height[high]) {
                low++;
            }else {
                high--;
            }
        }
        return res;
    }

}
