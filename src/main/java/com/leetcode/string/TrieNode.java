package com.leetcode.string;

/**
 * trie
 *
 * @author weishibai
 * @date 2019/02/25 10:40 AM
 */
public class TrieNode {

    private TrieNode[] children;

    private boolean end;

    private char val;

    public TrieNode() {
        children = new TrieNode[26];
        end = false;
    }

    public TrieNode(char val) {
        this.val = val;
        children = new TrieNode[26];
        end = false;

    }

    public boolean contains(int pos) {
        return children[pos] != null;
    }

    public TrieNode buildChild(int pos, char c) {
        TrieNode node = new TrieNode(c);
        children[pos] = node;

        return node;
    }

    public TrieNode childOf(int pos) {
        return children[pos];
    }

}
