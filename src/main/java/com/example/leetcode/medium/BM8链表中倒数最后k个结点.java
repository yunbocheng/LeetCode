package com.example.leetcode.medium;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-04-21
 */
public class BM8链表中倒数最后k个结点 {

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
        ListNode listNode = FindKthToTail(head, 6);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }

    /*
    * 获取末尾指定的节点
    * */
    public static ListNode FindKthToTail(ListNode pHead, int k) {
        if (pHead == null || k <= 0) {
            return null;
        }
        ListNode test = pHead;
        int j = 0;
        while (test != null) {
            j++;
            test = test.next;
        }
        if (j < k) {
            return null;
        }
        ListNode head = reversalListNode(pHead);
        int i = 0;
        ListNode res = new ListNode(0);
        ListNode cur = res;
        while (i < k && head != null) {
            cur.next = head;
            cur = cur.next;
            head = head.next;
            i++;
        }
        cur.next = null;
        return reversalListNode(res.next);
    }


    /*
    * 反转节点
    * */
    public static ListNode reversalListNode(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }


    /*
    * 方法二：直接找到位置进行赋值
    * */
    public static ListNode FindKthToTail2(ListNode pHead, int k) {
        if (pHead == null) {
            return null;
        }
        int j = 0;
        ListNode cur = pHead;
        while (cur != null) {
            j++;
            cur = cur.next;
        }
        if (j < k) {
            return null;
        }
        cur = pHead;
        //遍历n-k次
        for(int i = 0; i < j - k; i++) {
            cur = cur.next;
        }
        return cur;
    }

}
