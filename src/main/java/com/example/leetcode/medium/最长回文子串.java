package com.example.leetcode.medium;

/**
 * <p>
 *
 * </p>
 *
 * @author chengyunbo03@gyyx.cn
 * @since 2024-12-25 11:28
 */

public class 最长回文子串 {

    public static void main(String[] args) {
        String s = "ababc";
        System.out.println(getLongestPalindrome(s));
    }

    public static String getLongestPalindrome (String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int strLen = s.length();
        boolean[][] dp  = new boolean[strLen][strLen];
        //记录最大回文字串起始位置
        int begin = 0;
        int end = 0;
        //记录回文字串的最大长度
        int maxLen = 1;
        for (int i = 1; i < strLen; i++) {
            for (int j = 0; j < i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i-j <=2 || dp[j+1][i-1])) {
                    dp[j][i] = true;
                    if (i - j + 1 > maxLen) {
                        maxLen = i-j+1;
                        end = i;
                        begin = j;
                    }
                }
            }
        }
        return s.substring(begin, end+1);
    }

}
