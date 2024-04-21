package com.example.leetcode.easy.link;

import java.util.Objects;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-04-21
 */
public class BM2链表内指定区间反转 {

    public static class ListNode{
        private int val;

        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ListNode listNode = (ListNode) o;
            return val == listNode.val && Objects.equals(next, listNode.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, next);
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

    }

    /*
    * 链表指定区间反转
    * */
    public ListNode reverseBetween (ListNode head, int m, int n) {
        if (head == null || (m <= 0 && n <=0)) {
            return null;
        }

    }
}
