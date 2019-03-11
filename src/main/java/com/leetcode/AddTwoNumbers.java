package com.leetcode;

/**
 * add two numbers
 *
 * @author weishibai
 * @date 2019/02/22 10:32 AM
 * @leetcode https://leetcode-cn.com/problems/add-two-numbers/
 *
 */
public class AddTwoNumbers {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode h1 = new ListNode(2);
        h1.next = new ListNode(4);
        h1.next.next = new ListNode(3);

        ListNode h2 = new ListNode(5);
        h2.next = new ListNode(6);
        h2.next.next = new ListNode(6);
        h2.next.next.next = new ListNode(9);

        AddTwoNumbers numbers = new AddTwoNumbers();
        ListNode result = numbers.addTwoNumbers(h1, h2);
        printNode(result);
    }

    private static void printNode(ListNode result) {
        while (result != null) {
            System.out.println(result.val + " -> ");
            result = result.next;
        }
    }
}
