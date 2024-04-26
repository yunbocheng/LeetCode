package com.example.link;

/**
 * @author : YunboCheng
 * @date : 18:42 2024/4/20
 */
public class 链表实现一个队列 {


    /*
    * Node节点类，存储节点信息
    * */
    public static class Node<V> {
        private V value;

        private Node<V> next;

        public Node (V value){
            this.value = value;
            this.next = null;
        }

    }

    /*
    * 队列类，向队列中存储元素
    * 先进先出（存在头尾）
    * */
    public static class MyQueue<V> {
        private Node<V> head;
        private Node<V> tail;

        private int size;

        /*
        * 获取队列长度
        * */
        public int getQueueSize() {
            return size;
        }

        /*
        * 判断队列是否为空
        * */
        public boolean isEmpty() {
            return size == 0;
        }

        /*
        * 进入队列的方法
        * */
        public void offer(V value) {
            Node<V> node = new Node<>(value);
            if (tail == null) {
                head = node;
                tail = node;
            }else {
                tail.next = node;
                tail = node;
            }
            size++;
        }

        /*
        * 出队列方法
        * */
        public V pop() {
            V ans = null;
            if (head != null) {
                ans = head.value;
                head = head.next;
                size--;
            }
            if (head == null) {
                tail = null;
            }
            return ans;
        }

        /*
        * 简单的要值，不从队列中弹出
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
