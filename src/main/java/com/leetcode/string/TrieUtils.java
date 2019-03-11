package com.leetcode.string;

import java.util.List;

/**
 * trie utils
 *
 * @author weishibai
 * @date 2019/02/25 10:50 AM
 */
public class TrieUtils {


    public static TrieNode buildTrie(List<String> dict) {
        if (dict == null || dict.size() == 0) {
            return null;
        }

        TrieNode root = new TrieNode();
        for (String str : dict) {
            char[] chars = str.toCharArray();
            for (char ch : chars) {
                int pos = ch - 'a';
                if (!root.contains(pos)) {
                    root = root.buildChild(pos, ch);
                } else {
                    root = root.childOf(pos);
                }
            }
        }





        return null;
    }
}
