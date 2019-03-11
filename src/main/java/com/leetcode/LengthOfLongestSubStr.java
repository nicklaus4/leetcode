package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * lengthOfLongestSubstring
 *
 * @author weishibai
 * @date 2019/02/22 11:09 AM
 */
public class LengthOfLongestSubStr {

    /**
     * 官方题解
     * @param s
     * @return
     */
    public int _lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int i = 0;
        int j = 0;
        Set<Character> contained = new HashSet<>(len);
        int max = 0;
        while (i <= j && i < len && j < len) {
            if (contained.contains(s.charAt(j))) {
                contained.remove(s.charAt(i));
                i ++;
            } else {
                contained.add(s.charAt(j));
                max = Math.max(max, contained.size());
                j ++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LengthOfLongestSubStr subStr = new LengthOfLongestSubStr();
        System.out.println(subStr.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(subStr.lengthOfLongestSubstring("bbbbb"));
        System.out.println(subStr.lengthOfLongestSubstring("pwwkew"));
    }
}
