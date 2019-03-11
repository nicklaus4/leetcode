package com.leetcode.list;

/**
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 *
 * @author weishibai
 * @date 2019/02/24 11:38 AM
 */
public class SwapListNode {


    //给定 1->2->3->4, 你应该返回 2->1->4->3.
    public ListNode swapPairs(ListNode head) {
        if (null == head) {
            return null;
        }

        ListNode first = head;
        ListNode second = head.next;

        if (second == null) {
            return head;
        }

        swap(first, second);
        ListNode tmp = first;
        first = second;
        second = tmp;
        head = first;
        while (true) {
            if (first.next.next == null) {
                return head;
            }
            first = first.next.next;

            if (second.next.next == null) {
                return head;
            }
            ListNode pre = second;
            second = second.next.next;
            swap(first, second);
            pre.next = second;
            tmp = first;
            first = second;
            second = tmp;
        }
    }

    private void swap(ListNode first, ListNode second) {
        ListNode f = first;
        ListNode s = second;

        f.next = s.next;
        s.next = f;
    }

    public static void main(String[] args) {
        SwapListNode node = new SwapListNode();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode listNode = node.swapPairs(head);
        LinkedListUtils.printList(listNode);
    }

}
