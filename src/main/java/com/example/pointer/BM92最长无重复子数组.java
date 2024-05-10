package com.example.pointer;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-04-30
 */
public class BM92最长无重复子数组 {

    public static void main(String[] args) {
        int[] arr = new int[]{2,3,4,3,5};
        System.out.println(maxLength(arr));
    }

    public static int maxLength (int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int low = 0;
        int high = 0;
        int max = 0;
        Set<Integer> set = new HashSet<>();
        while (high < arr.length) {
            if (!set.contains(arr[high])) {
                set.add(arr[high]);
                high++;
            }else {
                set.remove(arr[low]);
                low++;
            }
            max = Math.max(max, set.size());
        }
        return max;
    }

}
