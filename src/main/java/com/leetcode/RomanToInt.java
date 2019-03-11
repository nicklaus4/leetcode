package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * roma
 *
 * @author weishibai
 * @date 2019/02/10 7:23 PM
 */
public class RomanToInt {

    private static final Map<String, Integer> map = new HashMap<>();

    static {
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
    }

    public int romanToInt(String s) {
        int len = s.length();
        int result = 0;
        for (int i = 0; i < len - 1; i++) {
            int val = map.get(String.valueOf(s.charAt(i)));
            int next = map.get(String.valueOf(s.charAt(i + 1)));
            if (val >= next) {
                result += val;
            } else {
                result -= val;
            }
        }
        result += map.get(String.valueOf(s.charAt(len - 1)));
        return result;
    }

}
