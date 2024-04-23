package com.example.leetcode.easy.stack;

import java.util.Stack;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-04-22
 */
public class BM43包含min函数的栈 {

    // 存储正常入栈元素
    Stack<Integer> stack1 = new Stack<>();
    // 存储最小入栈元素
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        if (stack2.isEmpty() || stack2.peek() > node) {
            stack2.push(node);
        }else {
            stack1.push(node);
            stack2.push(stack1.peek());
        }
    }

    public void pop() {
        stack1.pop();
        stack2.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }

}
