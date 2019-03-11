package com.leetcode.list;

import java.util.Random;

/**
 * https://leetcode-cn.com/problems/linked-list-random-node/
 *
 * 蓄水池问题
 * https://blog.csdn.net/huagong_adu/article/details/7619665
 *
 * @author weishibai
 * @date 2019/02/25 4:43 PM
 */
public class RandomListNode {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    static class Solution {

        private ListNode head;

        /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
        public Solution(ListNode head) {
            this.head = head;

        }

        /** Returns a random node's value. */
        public int getRandom() {
            int result = head.val;
            int i = 2;
            Random rand = new Random();
            ListNode node = head.next;
            while (node != null) {
                if (rand.nextInt(i) == 0) {
                    result = node.val;
                }
                i ++;
                node = node.next;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        RandomListNode node = new RandomListNode();


        Solution solution = new Solution(head);
        System.out.println(solution.getRandom());
        System.out.println(solution.getRandom());
        System.out.println(solution.getRandom());
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */

}
