package com.example.sort;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-04-19
 */


/*
* 二分查找
*
* */
public class BM1二分查找1 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param nums int整型一维数组
     * @param target int整型
     * @return int整型
     *
     * 输入：
     * [-1,0,3,4,6,10,13,14],13
     * 复制
     * 返回值：
     * 6
     * 复制
     * 说明：
     * 13 出现在nums中并且下标为 6
     */

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,3,4,6,10,13,14};
        int target = 10;
        int index = binarySearch(nums, target);
        System.out.println(index);
    }

    /*
    * 暴力法
    * */
    public static int search (int[] nums, int target) {
        int index = -1;
        if (nums == null || nums.length == 0) {
            return index;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                index = i;
            }
        }
        return index;
    }


    /*
    * 二分查找
    * */
    public static int binarySearch(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        // 使用二分查找
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            }else if (nums[mid] < target){
                low+=1;
            }else {
                high-=1;
            }
        }
        return -1;
    }

}
