package com.example.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author chengyunbo03@gyyx.cn
 * @since 2024-12-26 11:04
 */
/*
* 题解：
* 1. res[i] += c: 把每个字符 c 追加到对应的行 si
* 2. i += flag: 更新当前字符 c 对应的行索引
* 3. flag = -flag: 在达到Z字形转折点时，执行反向
* */
public class Z字形变换 {

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        System.out.println(convert(s, numRows));
        System.out.println(-123%10);
    }

    public static String convert(String s, int numRows) {
        if (s == null || numRows < 2) {
            return s;
        }
        List<StringBuffer> list = new ArrayList<>();
        //向集合中添加对应数量的元素
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuffer());
        }
        //设置获取字符串的索引以及计算索引的标志
        int i = 0, flag = -1;
        for (char c : s.toCharArray()) {
            list.get(i).append(c);
            //判断是否是Z形的转折点
            if (i == 0 || i == numRows -1) flag = -flag;
            i+=flag;
        }
        //拼接list中的StringBuffer元素
        StringBuilder res = new StringBuilder();
        for (StringBuffer buffer : list) {
            res.append(buffer);
        }
        return res.toString();
    }
}
