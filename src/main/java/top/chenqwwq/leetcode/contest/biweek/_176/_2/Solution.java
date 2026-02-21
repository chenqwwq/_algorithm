package top.chenqwwq.leetcode.contest.biweek._176._2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenqwwq
 * @date 2026/2/14
 **/
public class Solution {
    public int prefixConnected(String[] words, int k) {
        Map<String, Integer> cs = new HashMap<>();
        for (String word : words) {
            if (word.length() < k) continue;
            cs.merge(word.substring(0, k), 1, Integer::sum);
        }

        return Math.toIntExact(cs.entrySet().stream().filter(entry -> entry.getValue() >= 2).count());
    }
}