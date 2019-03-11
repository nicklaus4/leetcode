package com.leetcode.list;

/**
 * linked list utils
 *
 * @author weishibai
 * @date 2019/02/24 12:04 PM
 */
public class LinkedListUtils {


    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
    }

}
