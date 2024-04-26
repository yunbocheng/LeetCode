package com.example.link;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-04-26
 * 输入：
 * [{1,2},{1,4,5},{6}]
 * 返回值：
 * {1,1,2,4,5,6}
 */
public class BM5合并k个已排序的链表 {

    private static class ListNode {

        private int val;

        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(4);
        head2.next.next = new ListNode(5);

        ListNode head3 = new ListNode(6);

        ArrayList<ListNode> list = new ArrayList<>(Arrays.asList(head1, head2, head3));
        ListNode listNode = mergeKLists(list);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode mergeKLists (ArrayList<ListNode> lists) {
        if (lists.isEmpty()) {
            return null;
        }
        /*
        * 解题思路：
        * 1. 将链表中的元素依次取出存储到ArrayList<Integer>数组中
        * 2. 对集合进行排序
        * 3. 组合成一个新的链表
        * */
        // 1.将node节点值存储到集合中
        List<Integer> resList = new ArrayList<>();
        for (int i = 0; i < lists.size(); i++) {
            ListNode listNode = lists.get(i);
            while (listNode != null) {
                resList.add(listNode.val);
                listNode = listNode.next;
            }
        }
        // 2.排序
        Collections.sort(resList);
        // 3.重组链表
        // 新建一个链表，指定头节点
        ListNode res = new ListNode(-1);
        ListNode cur = res;
        for (int i = 0; i < resList.size(); i++) {
            cur.next = new ListNode(resList.get(i));
            cur = cur.next;
        }
        return res.next;
    }

}
