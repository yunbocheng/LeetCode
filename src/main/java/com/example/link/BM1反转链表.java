package com.example.link;

/**
 * @author : YunboCheng
 * @date : 18:00 2024/4/20
 */

/*
* 反转链表
* 1->2->3
*
* 3->2->1
*
* */

public class BM1反转链表 {

    public static class Node {
        private int value;

        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        /*
        * 构建一个链表
        * */
        Node n1 = new Node(1);
        n1.next = new Node(2);
        n1.next.next = new Node(3);

//        while (n1 != null) {
//            System.out.println(n1.value);
//            n1 = n1.next;
//        }

        Node head = inversionNode(n1);
        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }

    }

    public static Node inversionNode(Node head) {
        if (head == null) {
            return null;
        }
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

}
