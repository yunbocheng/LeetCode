package com.example.string;

import java.util.Arrays;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-04-22
 */
public class BM83字符串变形 {

    public static void main(String[] args) {
        String str = "h i ";
        String trans = trans(str, 1);
        System.out.println(trans);
    }


    public static String trans (String s, int n) {
        String[] strArray = s.split(" ");

        StringBuilder strBuilder = new StringBuilder();
        for (int i = strArray.length - 1; i >= 0; i--) {
            strBuilder.append(reverse(strArray[i])); //数组转换为字符串
            //最后一个字符串后面不再附加空格
            if(i == 0) {
                break;
            }
            //字符串之间附加空格
            strBuilder.append(" ");
        }
        return strBuilder.toString();
    }

    //大小写转换
    private static String reverse(String s){
        StringBuilder res= new StringBuilder();
        for(char ch:s.toCharArray()){
            if(Character.isLowerCase(ch)){
                res.append(Character.toUpperCase(ch));
            } else if(Character.isUpperCase(ch)){
                res.append(Character.toLowerCase(ch));
            }
        }
        return res.toString();
    }
}
