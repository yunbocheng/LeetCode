package com.example.string;

import java.math.BigInteger;

/**
 * @author : YunboCheng
 * @date : 22:53 2024/4/29
 */
public class BM86大数加法 {

    public static void main(String[] args) {
        String s = "1";
        String t = "99";
        String solve = solve(s, t);
        System.out.println(solve);
    }

    public static String solve (String s, String t) {
        BigInteger num1 = new BigInteger(s);
        BigInteger num2 = new BigInteger(t);

        return num1.add(num2).toString();
    }

}
