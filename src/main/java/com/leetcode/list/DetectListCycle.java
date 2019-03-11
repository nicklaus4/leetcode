package com.leetcode.list;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 *
 * https://blog.csdn.net/hujinglovekmg/article/details/78435952#jump1
 *
 * @author weishibai
 * @date 2019/02/24 9:50 AM
 */
public class DetectListCycle {

    public boolean hasCycle(ListNode head) {
        if (null == head) {
            return false;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (true) {
            if (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
            } else {
                return false;
            }

            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }
    }

    /**
     * x == (k - 1) * (d + c) + d
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (null == head) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (true) {
            if (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }

            slow = slow.next;
            if (slow == fast) {
                break;
            }
        }

        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    public static void main(String[] args) {
        DetectListCycle cycle = new DetectListCycle();
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;

        ListNode listNode = cycle.detectCycle(head);
    }


}
