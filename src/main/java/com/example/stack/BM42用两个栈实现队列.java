package com.example.stack;

import java.util.Stack;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-04-22
 */
public class BM42用两个栈实现队列 {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        // 先将栈1中的数据存储到栈2
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        // 取出元素，队首
        int res = stack2.pop();
        // 再将剩余元素写会 stack1
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return res;
    }

}
