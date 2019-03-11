package com.leetcode.string;

/**
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/
 *
 * @author weishibai
 * @date 2019/02/25 11:33 AM
 */

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
public class Trie {

    private char val;

    private boolean end;

    private Trie[] children;

    /** Initialize your data structure here. */
    public Trie() {
        children = new Trie[26];
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (null == word || "".equalsIgnoreCase(word)) {
            return;
        }

        char[] chars = word.toCharArray();
        Trie root = this;
        for (char ch : chars) {
            int pos = ch - 'a';
            if (root.children[pos] == null) {
                Trie node = new Trie();
                node.val = ch;
                root.children[pos] = node;
                root = node;
            } else {
                root = root.children[pos];
            }
        }
        root.end = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (null == word || "".equalsIgnoreCase(word)) {
            return false;
        }

        char[] chars = word.toCharArray();
        Trie root = this;
        for (char ch : chars) {
            int pos = ch - 'a';
            if (root.children[pos] == null) {
                return false;
            } else {
                root = root.children[pos];
            }
        }
        return root.end;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if (null == prefix || "".equalsIgnoreCase(prefix)) {
            return false;
        }

        char[] chars = prefix.toCharArray();
        Trie root = this;

        for (char ch : chars) {
            int pos = ch - 'a';
            if (root.children[pos] == null) {
                return false;
            } else {
                root = root.children[pos];
            }
        }
        return true;
    }

//    public static void main(String[] args) {
//        Trie trie = new Trie();
//
//        trie.insert("apple");
//        System.out.println(trie.search("apple"));   // 返回 true
//        System.out.println(trie.search("app"));     // 返回 false
//        System.out.println(trie.startsWith("app")); // 返回 true
//        trie.insert("app");
//        System.out.println(trie.search("app"));     // 返回 true
//    }

}
