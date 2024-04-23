package com.example.leetcode.easy.pointer;

import java.util.Arrays;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-04-22
 */
public class BM91反转字符串 {

    public static void main(String[] args) {
        String str = "abcd";
        System.out.println(solve(str));
    }

    public static String solve (String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        char[] charArray = str.toCharArray();
        for (int i = 0, j = charArray.length -1 ;i < j; i ++, j--) {
            char temp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = temp;
        }
        StringBuilder buffer = new StringBuilder();
        for (char c : charArray) {
            buffer.append(c);
        }
        return String.valueOf(buffer);
    }

}
