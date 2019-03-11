package com.leetcode.list;

/**
 * https://leetcode-cn.com/problems/odd-even-linked-list/
 *
 * @author weishibai
 * @date 2019/02/24 2:00 PM
 */
public class AddEvenList {

    public ListNode oddEvenList(ListNode head) {
        if (null == head) {
            return null;
        }
        ListNode oddHead = getOddList(head);
        ListNode evenHead = getEventList(head);
        ListNode current = oddHead;
        while (current.next != null) {
            current = current.next;
        }
        current.next = evenHead;
        return oddHead;
    }

    public ListNode getOddEvenList(ListNode head) {
        if (null == head) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        ListNode oddCurrent = head;
        ListNode evenHead = head.next;
        ListNode evenCurrent = head.next;

        while (oddCurrent.next != null && evenCurrent.next != null) {
            oddCurrent.next = evenCurrent.next;
            oddCurrent = oddCurrent.next;
            evenCurrent.next = oddCurrent.next;
            evenCurrent = evenCurrent.next;
        }
        oddCurrent.next = evenHead;
        return head;
    }

    private ListNode getOddList(ListNode head) {
        ListNode oddHead = head;
        ListNode current = head;

        while (current.next != null && current.next.next != null) {
            ListNode nxt = current.next.next;
            current.next = nxt;
            current = nxt;
        }
        return oddHead;
    }

    private ListNode getEventList(ListNode head) {
        if (head.next == null) {
            return null;
        }

        ListNode evenHead = head.next;
        ListNode current = head.next;

        while (current.next != null && current.next.next != null) {
            ListNode nxt = current.next.next;
            current.next = nxt;
            current = nxt;
        }
        return evenHead;
    }

}
