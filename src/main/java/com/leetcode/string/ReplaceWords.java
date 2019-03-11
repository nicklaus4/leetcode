package com.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/replace-words/
 *
 * @author weishibai
 * @date 2019/02/25 10:24 AM
 */
public class ReplaceWords {

    private class TrieNode {

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

    public TrieNode buildTrie(List<String> dict) {
        if (dict == null || dict.size() == 0) {
            return null;
        }

        TrieNode root = new TrieNode();
        for (String str : dict) {
            TrieNode node = root;
            char[] chars = str.toCharArray();
            for (char ch : chars) {
                int pos = ch - 'a';
                if (!node.contains(pos)) {
                    node = node.buildChild(pos, ch);
                } else {
                    node = node.childOf(pos);
                }
            }
            node.end = true;
        }
        return root;
    }

    private String searchWord(TrieNode root, String word) {
        if (null == word || "".equals(word)) {
            return word;
        }

        TrieNode node = root;
        char[] chars = word.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char ch : chars) {
            int pos = ch - 'a';
            if (node.contains(pos)) {
                node = node.childOf(pos);
                sb.append(ch);
                if (node.end) {
                    return sb.toString();
                }
            } else {
                return word;
            }
        }
        return sb.toString();
    }

    public String replaceWords(List<String> dict, String sentence) {
        if (sentence == null || sentence.length() == 0) {
            return sentence;
        }

        TrieNode root = buildTrie(dict);
        if (null == root) {
            return sentence;
        }

        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(searchWord(root, word)).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static void main(String[] args) {
        ReplaceWords words = new ReplaceWords();
        List<String> list = new ArrayList<>();
        list.add("cat");
        list.add("bat");
        list.add("rat");
        System.out.println(words.replaceWords(list, "the cattle was rattled by the battery"));
    }




}
