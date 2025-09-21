package top.chenqwwq.leetcode.contest.weekly._324._1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenqwwq
 * @date 2022/12/18
 **/
public class Solution {
    public int similarPairs(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            int[] hash = new int[26];
            for (int i = 0; i < word.length(); i++) {
                hash[word.charAt(i) - 'a'] = 1;
            }
            String num = "";
            for (int h : hash) {
                num += h;
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int ans = 0;
        for (Integer cnt : map.values()) {
            if (cnt < 2) continue;
            ;
            ans += (cnt * (cnt - 1)) / 2;
        }
        return ans;
    }
}
