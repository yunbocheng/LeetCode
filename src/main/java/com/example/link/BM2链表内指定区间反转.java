package com.example.link;

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
        ListNode listNode = reverseBetween(head, 2, 4);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }

    /*
    * 链表指定区间反转
    * */
    public static ListNode reverseBetween (ListNode head, int m, int n) {
        if (head == null ) {
            return null;
        }
        if (m <= 0 && n <=0) {
            return head;
        }
        // 加个表头，防止从1开始反转
        ListNode res = new ListNode(-1);
        res.next = head;
        ListNode pre = res;
        ListNode cur = head;

        // 让pre和cur一直向前移动，找到反转的起始位置 m
        for (int i = 0; i < m-1; i++) {
            pre = pre.next;
            cur = cur.next;
        }

        // 当跳出上边的循环说明找到了开始转换的其实节点，循环反转
        for (int i = 0; i < n-m; i++) {
            ListNode temp = cur.next;
            cur.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
        }
        //返回时减掉我们自己加的头节点
        return res.next;
    }
}
