package com.example.plan;

/**
 * @author : YunboCheng
 * @date : 0:40 2024/4/23
 */
public class BM62斐波那契数列 {

    public static void main(String[] args) {
        int n = 4;
        System.out.println(Fibonacci(n));
    }


    public static int Fibonacci (int n) {
        if (n <= 1) {
            return n;
        }
        int res = 0;
        int a = 0;
        int b = 1;
        for (int i = 2 ; i<=n ; i++) {
            res = a + b;
            a = b;
            b = res;
        }
        return res;
    }

}
