package com.example.leetcode.easy.link;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-04-21
 */
public class BM6判断链表中是否有环 {


    public static class ListNode {
        private int val;

        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        // 5 -> 3 构建环形链表
        head.next.next.next.next.next = head.next.next;
        boolean b = hasCycle(head);
        System.out.println(b);
    }

    /*
    * 使用一个快慢指针，如果快慢指针会相等，一定存在环
    * */
    public static boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        // 建立快慢指针
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

}
