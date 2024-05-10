package com.example.arr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-04-30
 */
public class BM97旋转数组 {

    public static void main(String[] args) {

        // 6,2,[1,2,3,4,5,6]
        // 结果 [5,6,1,2,3,4]
        int[] arr = new int[]{1,2,3,4,5,6};
        System.out.println(Arrays.toString(solve(6,2, arr)));

    }

    public static int[] solve (int n, int m, int[] a) {
        if (a == null || a.length == 0) {
            return null;
        }
        if (n > a.length) {
            return null;
        }
        // 防止m大于n，比如m大于n的话，那么就要忽略到一个n
        // 比如数组长度为4，但是m是5，那么就要忽略掉一个n(4)的长度，剩余的长度为1
        m = m % n;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            list.add(a[i]);
        }
        //截取最后m个元素
        List<Integer> list1 = list.subList(n-m, n);

        //截取除了最后m个元素
        List<Integer> list2 = list.subList(0, n-m);
        list1.addAll(list2);
        int[] res = new int[list1.size()];
        for (int i = 0; i < list1.size(); i++) {
            res[i] = list1.get(i);
        }
        return res;
    }
}
