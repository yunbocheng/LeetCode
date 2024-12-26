package com.example.leetcode.medium;

/**
 * <p>
 *
 * </p>
 *
 * @author chengyunbo03@gyyx.cn
 * @since 2024-12-26 12:24
 */
/*
* 解题思路：
* 每次获取最后一个拼接到最前方
* */
public class 整数反转 {

    public static void main(String[] args) {
        int x = -123;
        System.out.println(reverse(x));
    }

    public static int reverse(int x) {
        int res = 0;
        int last = 0;
        while (x != 0) {
            //获取尾部数字
            int tmp = x%10;
            last = res;
            res = res*10+tmp;
            if (last != res/10) {
                return 0;
            }
            x/=10;
        }
        return res;
    }

}
