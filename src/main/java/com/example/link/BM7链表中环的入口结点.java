package com.example.link;

import java.util.Objects;

/**
 * @author : YunboCheng
 * @date : 23:58 2024/4/21
 */
public class BM7链表中环的入口结点 {

    public static class ListNode{
        private int val;

        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
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
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = head.next.next;
        ListNode listNode = EntryNodeOfLoop(head);
        System.out.println(listNode.val);

    }

    /*
    *
    * 链表中环的入口节点
    * */
    public static ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        // 使用快慢指针，当第一次相遇时，将块指针置到头节点，然后依次循环，在相等时就是环的入口节点
        ListNode slow = pHead;
        ListNode fast = pHead;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode slow2 = pHead;
                while (slow2 != slow) {
                    slow2 = slow2.next;
                    slow = slow.next;
                }
                return slow2;
            }
        }
        return null;
    }

}
