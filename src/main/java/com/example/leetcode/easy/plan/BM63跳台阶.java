package com.example.leetcode.easy.plan;

/**
 * @author : YunboCheng
 * @date : 0:55 2024/4/23
 */
public class BM63跳台阶 {


    public static void main(String[] args) {
        int n = 4;
    }

    /*
    * 我们想象青蛙此时在最高点，想象称下楼梯，它在n阶，向下走要不 (n-1) + (n-2) 两种方式
    * 斐波那契出来了 f(n) = f(n-1) + f(n-2)
    * */
    public int jumpFloor (int number) {
        if (number <= 1) {
            return number;
        }
        int res = 0;
        int a = 1;
        int b = 1;
        for (int i = 2 ; i <= number ; i++) {
            res = a + b;
            a = b;
            b = res;
        }
        return res;
    }

}
