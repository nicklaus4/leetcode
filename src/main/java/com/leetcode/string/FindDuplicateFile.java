package com.leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/find-duplicate-file-in-system/
 *
 *  实际场景下 这种解法不可能
 *  应该是md5这种摘要算法
 * @author weishibai
 * @date 2019/02/27 1:30 PM
 */
public class FindDuplicateFile {


    public List<List<String>> findDuplicate(String[] paths) {
        if (paths.length == 0) {
            return Arrays.asList();
        }
        //创建Map存放文件名和对应的目录
        Map<String, List<String>> map = new HashMap<>();
        //遍历集合，取出文件名和目录
        String[] strs = null;
        List<String> list = null;
        String content = "";
        for (int i = 0; i < paths.length; i++) {
            strs = paths[i].split(" ");
            //通过空格分割字符串
            for (int j = 1; j < strs.length; j++) {
                //取出文件内容
                content = getContent(strs[j]);
                if (map.get(content) == null) {//map中没放入该内容
                    list = new ArrayList<>();
                    list.add(strs[0] + "/" + strs[j].substring(0, strs[j].length() - content.length() - 2));
                    map.put(content, list);
                } else {
                    list = map.get(content);
                    list.add(strs[0] + "/" + strs[j].substring(0, strs[j].length() - content.length() - 2));
                }
            }
        }
        //取出结果放在结果集中
        List<List<String>> result = new ArrayList<>();
        Set<String> keys = map.keySet();
        for (String key : keys) {
            list = map.get(key);
            if (list.size() > 1) {
                result.add(list);
            }
        }
        return result;
    }

    public static String getContent(String fileName) {
        int index = fileName.length() - 2;
        while (fileName.charAt(index) != '(') {
            index--;
        }
        return fileName.substring(index + 1, fileName.length() - 1);
    }

}
