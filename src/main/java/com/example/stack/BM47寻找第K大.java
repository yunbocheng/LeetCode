package com.example.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-05-08
 */
public class BM47寻找第K大 {

    public static void main(String[] args) {
        int[] a = new int[]{10,10,9,9,8,7,5,6,4,3,4,2};
        System.out.println(findKth(a, 12, 3));
    }

    public static int findKth (int[] a, int n, int K) {
        if (a == null || a.length == 0) {
            return -1;
        }
        if (K < 0 || K > a.length) {
            return -1;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i<a.length; i++) {
            list.add(a[i]);
        }
        // 排序
        Collections.sort(list, (v1,v2)->v2.compareTo(v1));
        // 获取第K大的
        return list.get(K-1);
    }

}
