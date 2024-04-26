package com.example.link;

/**
 * @author : YunboCheng
 * @date : 23:37 2024/4/20
 */
public class BM15删除有序链表中重复的元素 {

    public static class ListNode{
        private int val;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }


    public static void main(String[] args) {
        /*
         * 构建两个列表
         * */
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        ListNode listNode = deleteDuplicates(head);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    /*
    * 删除重复元素
    * */
    public static ListNode deleteDuplicates (ListNode head) {
        if (head == null) {
            return null;
        }
        // 对链表新增、删除时尽量使用额外指针，从新指定头部，不要在原链表上修改
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return head;
    }

}
