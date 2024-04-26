package com.example.link;

/**
 * @author : YunboCheng
 * @date : 20:11 2024/4/20
 */
public class BM11链表相加 {

    public static class ListNode{
        private int value;
        private ListNode next;

        public ListNode(int value) {
            this.value = value;
        }
    }


    public static void main(String[] args) {
        /*
         * 构建两个列表
         * */
        ListNode head1 = new ListNode(9);
        head1.next = new ListNode(3);
        head1.next.next = new ListNode(7);


        ListNode head2 = new ListNode(6);
        head2.next = new ListNode(3);

        ListNode listNode = addInList(head1, head2);
        while (listNode != null) {
            System.out.println(listNode.value);
            listNode = listNode.next;
        }

    }


    /*
    * 定义一个反转链表的方法
    * */
    public static ListNode reversalListNode(ListNode head) {
        if (head == null) {
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
    * 定义累加的方法
    * */
    public static ListNode addInList(ListNode head1, ListNode head2) {

        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        // 旋转链表
        ListNode listNode1 = reversalListNode(head1);
        ListNode listNode2 = reversalListNode(head2);

        // 创建一个新链表，设置头节点为值-1
        ListNode res = new ListNode(-1);
        ListNode head = res;

        // 存储进位值
        int carry = 0;

        while (listNode1 != null || listNode2 != null || carry != 0) {
            int val1 = listNode1 != null ? listNode1.value : 0;
            int val2 = listNode2 != null ? listNode2.value : 0;

            // 计算下一个节点值
            int temp = val1 + val2 + carry;

            // 计算进位值
            carry = temp/10;

            // 向新链表中添加新元素
            head.next = new ListNode(temp % 10);
            head = head.next;

            // 移动原始累加链表位置
            if (listNode1 != null) {
                listNode1 = listNode1.next;
            }
            if (listNode2 != null) {
                listNode2 = listNode2.next;
            }
        }
        return reversalListNode(res.next);
    }
}
