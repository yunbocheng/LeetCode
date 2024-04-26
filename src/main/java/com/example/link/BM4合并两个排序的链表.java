package com.example.link;

/**
 * @author : YunboCheng
 * @date : 23:07 2024/4/20
 */
public class BM4合并两个排序的链表 {

    public static class ListNode {

        private int val;

        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(3);
        listNode1.next.next = new ListNode(5);

        ListNode listNode2 = new ListNode(2);
        listNode2.next = new ListNode(4);
        listNode2.next.next = new ListNode(6);

        ListNode merge = Merge(listNode1, listNode2);
        while (merge != null) {
            System.out.println(merge.val);
            merge = merge.next;
        }
    }


    /*
    * 定义合并的方法
    * */
    public static ListNode Merge (ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null) {
            return pHead2;
        }
        if (pHead2 == null) {
            return pHead1;
        }

        ListNode head = pHead1.val >= pHead2.val ? pHead2 : pHead1;
        ListNode cur1 = head.next;
        ListNode cur2 = head == pHead1 ? pHead2 : pHead1;
        ListNode pre = head;
        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                pre.next = cur1;
                cur1 = cur1.next;
            }else {
                pre.next = cur2;
                cur2 = cur2.next;
            }
            pre = pre.next;
        }
        pre.next = cur1 == null ? cur2 : cur1;
        return head;
    }

}
