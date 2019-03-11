package com.leetcode.list;

/**
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 *
 * @author weishibai
 * @date 2019/02/24 12:24 PM
 */
public class KSwapListNode {

    /* k个reverse 保存好prev跟next别断链就行 */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (null == head) {
            return null;
        }

        if (k == 1) {
            return head;
        }

        ListNode reverseHead = null;
        ListNode current = head;
        ListNode prev = null;

        while (current != null) {
            ListNode nextK = getNextK(current, k);
            if (nextK == null) {
                if (prev != null) {
                    prev.next = current;
                    return reverseHead;
                }
                return head;
            }

            /* reverse k */
            ListNode start = current;
            ListNode nextSegStart = nextK.next;
            ListNode segmentReverseTail = current;
            ListNode nxt;
            ListNode segmentPrev = nextSegStart;

            int count = 1;
            while (count < k) {
                nxt = start.next;
                start.next = segmentPrev;
                segmentPrev = start;
                start = nxt;
                count ++;
            }
            start.next = segmentPrev;
            if (prev != null) {
                prev.next = start;
            }
            prev = segmentReverseTail;
            current = nextSegStart;

            if (reverseHead == null) {
                reverseHead = start;
            }
        }
        return reverseHead;
    }

    private ListNode getNextK(ListNode current, int k) {
        int count = 1;
        ListNode cur = current;
        while (cur != null && count < k) {
            count ++;
            cur = cur.next;
        }
        return cur;
    }

    public static void main(String[] args) {
        KSwapListNode node = new KSwapListNode();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        LinkedListUtils.printList(node.reverseKGroup(head, 3));
//        LinkedListUtils.printList(node.reverseKGroup(head, 2));
    }


}
