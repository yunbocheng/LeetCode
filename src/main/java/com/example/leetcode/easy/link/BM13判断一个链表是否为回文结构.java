package com.example.leetcode.easy.link;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-04-21
 */
public class BM13判断一个链表是否为回文结构 {

    public static class ListNode{
        private int val;

        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(2);
        boolean pail = isPail(head);
        System.out.println(pail);
    }

    public static boolean isPail (ListNode head) {
        if (head == null) {
            return false;
        }
        //借助第三方数组
        ArrayList<Integer> arrAsc = new ArrayList<>();
        while (head != null) {
            arrAsc.add(head.val);
            head = head.next;
        }
        for (int i = 0, j = arrAsc.size()-1; i < arrAsc.size(); i++, j--) {
            if (!Objects.equals(arrAsc.get(i), arrAsc.get(j))) {
                return false;
            }
        }
        return true;
    }

}
