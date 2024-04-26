package com.example.link;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-04-21
 */
public class BM10两个链表的第一个公共结点 {

    public static class ListNode {
        private int val;

        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        // 如果使用对象内容比较时，需要重写这个方法

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
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(6);
        head1.next.next.next.next = new ListNode(7);


        ListNode head2 = new ListNode(4);
        head2.next = new ListNode(5);
        head2.next.next = new ListNode(6);
        head2.next.next.next = new ListNode(7);
        ListNode listNode = FindFirstCommonNode(head1, head2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }

    /*
    * 使用 List 集合
    * */
    public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        List<ListNode> list = new ArrayList<>();
        while (pHead1 != null) {
            list.add(pHead1);
            pHead1 = pHead1.next;
        }
        while (pHead2 != null && !list.contains(pHead2)) pHead2 = pHead2.next;
        return pHead2;
    }
}
