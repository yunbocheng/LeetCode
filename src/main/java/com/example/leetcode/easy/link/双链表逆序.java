package com.example.leetcode.easy.link;

/**
 * @author : YunboCheng
 * @date : 18:11 2024/4/20
 */
public class 双链表逆序 {

    public static class Node{
        private int value;

        private Node next;

        private Node last;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        n1.next = new Node(2);
        n1.next.next = new Node(3);

        Node head = inversionTowNode(n1);
        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }

    }


    public static Node inversionTowNode(Node head) {
        if (head == null) {
            return null;
        }
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }

}
