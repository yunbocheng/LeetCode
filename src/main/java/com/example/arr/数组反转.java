package com.example.arr;

import java.util.Arrays;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-04-21
 */

/*
* [1, 2, 3, 4, 5, 6]
* */
public class 数组反转 {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6};
        reversalArr(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void reversalArr(int[] arr) {
        if (arr == null || arr.length == 1) {
            return;
        }
        for (int i = 0, j = arr.length - 1; i < arr.length; i++, j--) {
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }

}
