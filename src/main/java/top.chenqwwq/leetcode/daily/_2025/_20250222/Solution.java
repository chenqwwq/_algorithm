package top.chenqwwq.leetcode.daily._2025._20250222;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chenqwwq
 * @date 2025/2/22
 **/
public class Solution {
    public int similarPairs(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            final char[] cs = word.toCharArray();
            Arrays.sort(cs);
            StringBuilder hash = new StringBuilder();
            for (char c : cs) {
                if ((hash.isEmpty()) || hash.charAt(hash.length() - 1) != c) {
                    hash.append(c);
                }
            }
            final String key = hash.toString();
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        int ans = 0;
        for (Integer cnt : map.values()) {
            ans += cnt * (cnt - 1) / 2;
        }
        return ans;
    }
}