package com.example.pointer;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-04-22
 */
public class BM88判断是否为回文字符串 {

    public static void main(String[] args) {
        String str = "absba";
        System.out.println(judge(str) );
    }

    /*
    * 回文字符串，使用双指针
    * */
    public static boolean judge (String str) {
        if (str == null) {
            return false;
        }
        char[] charArray = str.toCharArray();
        for (int i = 0, j = charArray.length-1; i < charArray.length; i++,j--) {
            if (charArray[i] != charArray[j]) {
                return false;
            }
        }
        return true;
    }

}
