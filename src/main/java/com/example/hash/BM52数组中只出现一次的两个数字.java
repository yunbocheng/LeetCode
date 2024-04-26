package com.example.hash;

import java.util.*;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-04-22
 */
public class BM52数组中只出现一次的两个数字 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,4,1,6,4};
        System.out.println(Arrays.toString(FindNumsAppearOnce(nums)));

    }

    public static int[] FindNumsAppearOnce (int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.remove(nums[i]);
            }else {
                map.put(nums[i], 1);
            }
        }
        int[] res = new int[map.size()];
        Set<Integer> set = map.keySet();
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

}
