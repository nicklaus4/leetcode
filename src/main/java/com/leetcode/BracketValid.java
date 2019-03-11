package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/valid-parentheses/
 *
 * @author weishibai
 * @date 2019/02/26 2:35 PM
 */
public class BracketValid {

    private static final List<Character> symbols = new ArrayList<>();

    static {
        symbols.add('(');
        symbols.add('[');
        symbols.add('{');
    }

    public boolean isValid(String s) {
        if ("".equalsIgnoreCase(s)) {
            return true;
        }

        if (s.length() % 2 != 0) {
            return false;
        }

        final char[] chars = s.toCharArray();
        List<Character> stack = new ArrayList<>();
        for (char ch : chars) {
            if (symbols.contains(ch)) {
                stack.add(ch);
                continue;
            }

            if (stack.size() <= 0) {
                return false;
            }

            if (!isPair(stack.get(stack.size() - 1), ch)) {
                return false;
            }
            stack.remove(stack.size() - 1);
        }
        return stack.isEmpty();
    }

    private boolean isPair(char a, char b) {
        return (a == '(' && b == ')')
                || (a == '[' && b == ']')
                || (a == '{' && b == '}');
    }

    public static void main(String[] args) {
        BracketValid valid = new BracketValid();
//        System.out.println(valid.isValid("()"));
        System.out.println(valid.isValid("(("));
    }

}
