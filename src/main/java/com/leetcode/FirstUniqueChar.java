package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 *
 * @author weishibai
 * @date 2019/02/27 10:16 AM
 */
public class FirstUniqueChar {

    public int firstUniqChar(String s) {
        if ("".equals(s)) {
            return -1;
        }

        boolean[] exist = new boolean[26];
        int[] index = new int[26];
        List<Integer> queue = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            int ind = s.charAt(i) - 'a';
            if (exist[ind]) {
                queue.remove(new Integer(ind));
                continue;
            }
            exist[ind] = true;
            queue.add(ind);
            index[ind] = i;
        }

        if (queue.isEmpty()) {
            return -1;
        }
        return index[queue.get(0)];
    }

    /* better way */
    public int firstUniqChar0(String s) {
        char[] array = s.toCharArray();
        int[] a = new int[26];
        for (int i = 0; i < s.length(); i++) a[array[i] - 'a']++;
        for (int i = 0; i < s.length(); i++) {
            if (a[array[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FirstUniqueChar uniqueChar = new FirstUniqueChar();
        System.out.println(uniqueChar.firstUniqChar("leetcode"));
        System.out.println(uniqueChar.firstUniqChar("loveleetcode"));
    }
}
