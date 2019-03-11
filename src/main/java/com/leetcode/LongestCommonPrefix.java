package com.leetcode;

/**
 * dd
 *
 * @author weishibai
 * @date 2019/02/10 3:29 PM
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }

        int len = strs.length;
        String prefix = findCommonPrefix(strs[0], strs[1]);
        if (len == 2) {
            return prefix;
        }
        int i = 2;
        while (i < len) {
            prefix = findCommonPrefix(prefix, strs[i]);
            if (prefix.equalsIgnoreCase("")) {
                return "";
            }
            i ++;
        }
        return prefix;
    }

    public String findCommonPrefix(String stra, String strb) {
        int i = 0;
        while (i < stra.length() && i < strb.length()) {
            if (stra.charAt(i) != strb.charAt(i)) {
                if (i == 0) {
                    return "";
                }
                return stra.substring(0, i);
            }
            i++;
        }
        return stra.length() > strb.length() ? strb : stra;
    }

    public static void main(String[] args) {
        LongestCommonPrefix prefix = new LongestCommonPrefix();
        System.out.println(prefix.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(prefix.longestCommonPrefix(new String[]{"dog","racecar","car"}));
        System.out.println(prefix.longestCommonPrefix(new String[]{"dog","dacecar","dar"}));
    }

}
