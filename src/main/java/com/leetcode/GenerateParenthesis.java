package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/generate-parentheses/
 *
 * @author weishibai
 * @date 2019/02/26 2:09 PM
 */
public class GenerateParenthesis {


    private static final String[] symbols = new String[] {"(", ")"};

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(0, 0, n, n * 2, "", result);
        return result;
    }

    private void dfs(int left, int right, int total, int rest, String current, List<String> result) {
        if (left < right || right - left > total || left > total || right > total) {
            return;
        }

        if (rest == 0) {
            result.add(current);
            return;
        }

        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                String str = current + symbols[i];
                dfs(left + 1, right, total, rest - 1, str, result);
            } else {
                String str = current + symbols[i];
                dfs(left, right + 1, total, rest - 1, str, result);
            }
        }
    }

    public static void main(String[] args) {
        GenerateParenthesis parenthesis = new GenerateParenthesis();
        System.out.println(parenthesis.generateParenthesis(3));
        System.out.println(parenthesis.generateParenthesis(2));
        System.out.println(parenthesis.generateParenthesis(1));
    }



}
