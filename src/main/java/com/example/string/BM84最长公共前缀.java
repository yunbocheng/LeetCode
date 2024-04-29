package com.example.string;

/**
 * @author : YunboCheng
 * @date : 22:12 2024/4/29
 */
public class BM84最长公共前缀 {

    public static void main(String[] args) {
        //String[] strings = new String[]{"abca","abc","abca","abc","abcc"};
        String[] strings = new String[]{"",""};
        String s = longestCommonPrefix(strings);
        System.out.println(s);
    }

    public static String longestCommonPrefix (String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        int rows = strs.length;
        int cols = strs[0].length();
        for (int i = 0 ; i < cols; i++) {
            char first = strs[0].charAt(i);
            for (int j = 1; j < rows; j++) {
                if (i >= strs[j].length() || first != strs[j].charAt(i)) {
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }

}
