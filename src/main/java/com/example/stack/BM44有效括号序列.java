package com.example.stack;

import java.util.Stack;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-04-26
 */
public class BM44有效括号序列 {

    public static void main(String[] args) {
        String str = "(){}[]";
        boolean valid2 = isValid(str);
        System.out.println(valid2);

    }



    /*
    * 核心逻辑：
    * 使用栈结构
    * 当列表长度为奇时，直接入栈
    * */
    public static boolean isValid (String s) {
        if (s == null || s.length() % 2 == 1) {
            return false;
        }
        /*
        * 使用栈结构
        * 前后不一致 和 如果栈中还剩下元素，返回false 应对 "((" 这种结构
        * */
        Stack<Character> characterStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                characterStack.push(')');
            } else if (s.charAt(i) == '[') {
                characterStack.push(']');
            } else if (s.charAt(i) == '{') {
                characterStack.push('}');
            } else if (characterStack.isEmpty() || characterStack.pop() != s.charAt(i)) {
                return false;
            }
        }
        // 如果都在配对完之后栈中还有数据，说明其中存在类似这种 ((()[] 格式的数据
        return characterStack.isEmpty();
    }

}
