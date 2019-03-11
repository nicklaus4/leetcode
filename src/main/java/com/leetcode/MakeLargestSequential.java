package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/special-binary-string/
 *
 * @author weishibai
 * @date 2019/02/26 10:35 PM
 */
public class MakeLargestSequential {


    public String makeLargestSpecial(String s) {

        int count = 0;
        int ind = 0;
        List<String> list = new ArrayList<>();

        for (int i = 0; i < s.length(); i ++) {
            if (s.charAt(i) == '1') {
                count ++;
            } else {
                count --;
            }

            if (count == 0) {
                /* 找到了一个特殊的二进制子串 */
                list.add("1" + makeLargestSpecial(s.substring(ind + 1, i)) + "0");
                ind = i + 1;
            }
        }

        //对当前找到的特殊二进制字符串进行字典序排序
        Collections.sort(list, Collections.reverseOrder());
        return String.join("", list);
    }

    public static void main(String[] args) {
        MakeLargestSequential sequential = new MakeLargestSequential();
        System.out.println(sequential.makeLargestSpecial("11011000"));
    }

}
