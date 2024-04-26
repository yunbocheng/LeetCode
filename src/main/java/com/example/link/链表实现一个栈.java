package com.example.link;

/**
 * @author : YunboCheng
 * @date : 19:09 2024/4/20
 */
public class 链表实现一个栈 {

    /*
    * 定会一个Node类，存储信息
    * */
    public static class Node<V>{
        private V value;

        private Node<V> next;

        public Node (V value){
            this.value = value;
            this.next = null;
        }
    }

    /*
    * 定义一个栈类，存储node节点
    * 先进后出（只存在一个头，不存在尾）
    * */
    public static class MyStack<V> {
        private Node<V> head;

        private int size;

        /*
        * 初始化
        * */
        public MyStack() {
            this.head = null;
            this.size = 0;
        }

        public int getSize() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        /*
        * 入栈
        * */
        public void push(V value) {
            Node<V> node = new Node<>(value);
            if (head == null) {
                head = node;
            }else {
                head.next = node;
                head = node;
            }
            size++;
        }

        /*
        * 出栈
        * */
        public V pop() {
            V ans = null;
            if (head != null) {
                ans = head.value;
                head = head.next;
            }
            size--;
            return ans;
        }

        /*
        * 查看
        * */
        public V peek() {
            V ans = null;
            if (head != null) {
                ans = head.value;
            }
            return ans;
        }

    }


}
