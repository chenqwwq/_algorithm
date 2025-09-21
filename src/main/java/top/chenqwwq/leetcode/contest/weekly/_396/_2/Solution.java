package top.chenqwwq.leetcode.contest.weekly._396._2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenqwwq
 * @date 2024/5/5
 **/
public class Solution {
    public int minimumOperationsToMakeKPeriodic(String word, int k) {
        final int n = word.length();
        final Map<String, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < n; i += k) {
            final String s = word.substring(i, i + k);
            final int cnt = map.getOrDefault(s, 0) + 1;
            max = Math.max(max, cnt);
            map.put(s, cnt);
        }
        return n / k - max;
    }
}