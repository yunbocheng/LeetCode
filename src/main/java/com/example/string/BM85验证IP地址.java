package com.example.string;

import java.util.Objects;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-04-30
 */

/*
*
* 输入："172.16.254.1"
* 返回值："IPv4"
*
* 输入："2001:0db8:85a3:0:0:8A2E:0370:7334"
* 返回值："IPv6"
* */
public class BM85验证IP地址 {

    public static void main(String[] args) {
        String ip = "2001:0db8:85a3:0:0:8A2E:0370:7334:";
        String solve = solve(ip);
        System.out.println(solve);
    }

    public static String solve (String IP) {
        if (isIPv4(IP)) {
            return "IPv4";
        }
        if (isIPv6(IP)) {
            return "IPv6";
        }
        return "Neither";
    }


    public static boolean isIPv4(String ip) {
        if (ip == null) {
            return false;
        }
        // 字符串前后不能以存在 .
        if (ip.charAt(0) == '.' || ip.charAt(ip.length() - 1) == '.') {
            return false;
        }
        String[] split = ip.split("\\.");
        if (split.length != 4) {
            return false;
        }
        // 循环遍历数组中的每个元素的每个元素
        for (int i = 0 ;i < split.length; i++) {
            // 最多三位
            if (split[i].length() > 3) {
                return false;
            }
            // 判断是不是以0开头
            if (split[i].charAt(0) == '0') {
                return false;
            }
            //判断每个字符必须在 0~9
            for (int j = 0; j < split[i].length(); j++) {
                char charAt = split[i].charAt(j);
                if (charAt < '0' || charAt > '9') {
                    return false;
                }
            }
            // 判断元素是不是在 0~255之间
            int num = Integer.parseInt(split[i]);
            if (num <= 0 || num >= 255) {
                return false;
            }
        }
        return true;
    }


    // 2001:0db8:85a3:0:0:8A2E:0370:7334
    public static boolean isIPv6(String ip) {
        if (ip == null) {
            return false;
        }
        // 字符串前后不能以存在 :
        if (ip.charAt(0) == ':' || ip.charAt(ip.length() - 1) == ':') {
            return false;
        }
        String[] split = ip.split(":");
        if (split.length != 8) {
            return false;
        }
        //循环遍历数组中的每个元素
        //IPv6由8组16进制数组成，会出现a-fA-F，通过冒号分割，不可缺省，可以零开头，或者为一个单独零，每组最多4位。
        for (int i = 0 ; i < split.length; i++) {
            // 判断每组最多4位的情况
            if (split[i].length() > 4) {
                return false;
            }
            // 去除空字符串的干扰
            if (Objects.equals(split[i], "")) {
                return false;
            }
            // 判断字符必须在 0~9 a~f A~F 区间内
            for (int j = 0; j < split[i].length(); j++) {
                char charAt = split[i].charAt(j);
                if (!((charAt >= '0' && charAt <= '9') || (charAt >= 'a' && charAt <= 'f') || (charAt >= 'A') && (charAt <= 'F'))) {
                    return false;
                }
            }
        }
        return true;
    }

}
