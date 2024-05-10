package com.example.pointer;

/**
 * @author : YunboCheng
 * @date : 23:35 2024/4/29
 */
public class BM93盛水最多的容器 {

    public static void main(String[] args) {
        int[] height = new int[]{1,2,1};
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
            // 这个计算面积的结果必须放在移动指针的前边，因为如果是low=0，high=height-1的时候是盛水最多的，
            // 如果将这个计算面试的过放在移动指针的后面，那么相当于忽略了以上的那种情况
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
