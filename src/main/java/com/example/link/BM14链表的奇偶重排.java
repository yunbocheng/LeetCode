package com.example.link;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;


/**
 * @author : YunboCheng
 * @date : 0:22 2024/4/22
 */
public class BM14链表的奇偶重排 {

    public static class ListNode{
        private int val;
        private ListNode next;

        public ListNode(int val) {
            this.val =  val;
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
        ListNode listNode = oddEvenList(head);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }

    /*
    * 链表的解耦重排序
    * 借助ArrayList集合
    * */
    public static ListNode oddEvenList (ListNode head) {
        if (head == null) {
            return null;
        }
        ArrayList<ListNode> oddArr = new ArrayList<>();
        ArrayList<ListNode> evenArr = new ArrayList<>();

        int i = 1;
        while (head != null) {
            if (i % 2 != 0) {
                oddArr.add(head);
            }else {
                evenArr.add(head);
            }
            head = head.next;
            i++;
        }

        ListNode res = new ListNode(-1);
        ListNode cur = res;
        for (ListNode listNode : oddArr) {
            cur.next = listNode;
            cur = cur.next;
        }
        for (ListNode listNode : evenArr) {
            cur.next = listNode;
            cur = cur.next;
        }
        cur.next = null;
        return res.next;
    }


}
