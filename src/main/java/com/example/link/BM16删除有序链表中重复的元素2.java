package com.example.link;

/**
 * @author : YunboCheng
 * @date : 1:23 2024/4/21
 */
public class BM16删除有序链表中重复的元素2 {

    public static class ListNode{
        private int val;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);
        ListNode listNode = deleteDuplicates(head);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }

    public static ListNode deleteDuplicates (ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode cur = res;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int temp = cur.next.val;
                // 删除重复
                while (cur.next != null && cur.next.val == temp) {
                    cur.next = cur.next.next;
                }
            }else {
                cur = cur.next;
            }
        }
        return res.next;
    }
}
