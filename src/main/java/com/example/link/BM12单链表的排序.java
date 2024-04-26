package com.example.link;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-04-21
 */

/*
* 单链表排序
输入：[1,3,2,4,5]
返回值：{1,2,3,4,5}
*
* */
public class BM12单链表的排序 {

    public static class ListNode{
        private int val;

        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode listNode = sortInList(head);
        System.out.println(listNode);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    /*
    * 排序单链表
    * 借助数组的方式 arrayList
    * */
    public static ListNode sortInList (ListNode head) {
        if (head == null) {
            return null;
        }
        // 顶一个ArrayList集合中，将链表中的节点写入到集合中，对集合排序完成后在从新写入到链表
        ArrayList<Integer> arr = new ArrayList<>();
        while (head != null) {
            arr.add(head.val);
            head = head.next;
        }
        // 给数组排序
        Collections.sort(arr);
        ListNode res = new ListNode(arr.get(0));
        ListNode cur = res;
        for (int i = 1; i < arr.size(); i++) {
            cur.next = new ListNode(arr.get(i));
            cur = cur.next;
        }
        return res;
    }

}
