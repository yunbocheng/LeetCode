package com.example.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @author chengyunbo03@gyyx.cn
 * @since 2024-12-25 10:21
 */
/*
* 使用 Hash 以及 双指针方式
* */
public class 无重复字符的最长字串 {

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        //Map存储每个元素对应的最大下标值
        Map<Character,Integer> map = new HashMap<>();
        //子串的开始位置
        int begin = 0;
        //存储字串最大长度
        int max = 0;
        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                // 存在相似key的时候调整起始位置
                begin = Math.max(begin, map.get(c)+1);
            }
            //存储或修改该字符对应的下标位置
            map.put(c, end);
            //计算最大长度
            max = Math.max(max, end-begin+1);
        }
        return max;
    }

}
