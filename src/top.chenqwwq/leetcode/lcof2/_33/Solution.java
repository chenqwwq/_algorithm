package top.chenqwwq.leetcode.lcof2._33;

import java.util.*;

/**
 * @author chenbingxin
 * @date 2021/12/30
 **/
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        final List<List<String>> ans = new ArrayList<>();
        final Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            final String key = new String(array);
            if(map.containsKey(key)){
                map.get(key).add(str);
            }else {
                List<String> list = new ArrayList<>();
                ans.add(list);
                list.add(str);
                map.put(key, list);
            }
        }
        return ans;
    }
}
