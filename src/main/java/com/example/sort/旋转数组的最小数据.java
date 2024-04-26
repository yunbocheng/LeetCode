package com.example.sort;

/**
 * @author : YunboCheng
 * @date : 11:30 2024/4/20
 */
/*
* 旋转数据
*
* 0 1 1 2 5 6 7 8 9
*
* 2 5 6 7 8 9 0 1 1
*
* 使用二分查找法
* */
public class 旋转数组的最小数据 {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 4, 5, 6, 7 , -1 ,1, 1, 1, 2};
        int max = minNumberInRotateArray(nums);
        System.out.println(max);
    }

    public static int minNumberInRotateArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        /*
        * 使用二分查找法
        * */
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            }else if (nums[mid] == nums[high]) {
                high--;
            }else {
                high = mid;
            }
        }
        return nums[low];
    }
}
