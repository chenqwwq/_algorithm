package top.chenqwwq.leetcode.contest.biweek._90._1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenqwwq
 * @date 2022/10/31
 **/
public class Solution {
    public String oddString(String[] words) {
        Map<String, List<String>> map = new HashMap<>();
        for (var word : words) {
            String num = getNum(word);
            if (!map.containsKey(num)) map.put(num, new ArrayList<>());
            map.get(num).add(word);
        }
        for (var value : map.values()) {
            if (value.size() == 1) return value.get(0);
        }
        return "";
    }

    public String getNum(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length() - 1; i++) {
            sb.append(s.charAt(i + 1) - s.charAt(i)).append("#");
        }
        return sb.toString();
    }
}