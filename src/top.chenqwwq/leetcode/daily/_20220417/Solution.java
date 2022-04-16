package top.chenqwwq.leetcode.daily._20220417;


import java.util.*;

/**
 * @author chenqwwq
 * @date 2022/4/17
 **/
public class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> set = new HashSet<>();
        Collections.addAll(set, banned);

        Map<String, Integer> map = new HashMap<>();
        StringBuilder tmp = new StringBuilder();
        for (char c : paragraph.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                tmp.append(Character.toLowerCase(c));
            } else if (tmp.length() > 0) {
                map.put(tmp.toString(), map.getOrDefault(tmp.toString(), 0) + 1);
                tmp = new StringBuilder();
            }
        }
        if (tmp.length() > 0) {
            map.put(tmp.toString(), map.getOrDefault(tmp.toString(), 0) + 1);
        }
        int cnt = 0;
        String ans = null;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (!set.contains(entry.getKey()) && entry.getValue() > cnt) {
                ans = entry.getKey();
                cnt = entry.getValue();
            }
        }
        return ans;
    }
}