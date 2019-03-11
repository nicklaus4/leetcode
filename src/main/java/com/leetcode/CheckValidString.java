package com.leetcode;

/**
 * https://leetcode-cn.com/problems/valid-parenthesis-string/
 *
 * @author weishibai
 * @date 2019/02/26 7:12 PM
 */
public class CheckValidString {

    /* 两边扫描，* 可以分别作为)和( */
    public boolean checkValidString(String s) {
        if ("".equals(s)) {
            return true;
        }

        int count = 0;
        int replace = 0;
        final char[] chars = s.toCharArray();

        for (char ch : chars) {
            if (ch == '(') {
                count++;
                continue;
            }

            if (ch == '*') {
                replace++;
                continue;
            }

            if (0 == count) {
                if (replace <= 0) {
                    return false;
                }
                replace--;
                continue;
            }
            count--;
        }

        count = 0;
        replace = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = chars[i];
            if (ch == ')') {
                count++;
                continue;
            }

            if (ch == '*') {
                replace++;
                continue;
            }

            if (0 == count) {
                if (replace <= 0) {
                    return false;
                }
                replace--;
                continue;
            }
            count--;
        }
        return true;
    }

    public static void main(String[] args) {
        CheckValidString checkValidString = new CheckValidString();
        System.out.println(checkValidString.checkValidString("(*))"));
        System.out.println(checkValidString.checkValidString("(*)"));
        System.out.println(checkValidString.checkValidString("(("));
        System.out.println(checkValidString.checkValidString("(((******))"));
        System.out.println(checkValidString.checkValidString("(())((())()()(*)(*()(())())())()()((()())((()))(*"));
    }

}
