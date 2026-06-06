package top.chenqwwq.leetcode.daily._2022._20220917;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author chenqwwq
 * @date 2022/9/17
 **/
public class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        final int n = s.length();
        int[] hash = new int[26];
        Arrays.fill(hash, -1);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (hash[c - 'a'] == -1) hash[c - 'a'] = i;
            else ans = Math.max(i - hash[c - 'a'] - 1, ans);
        }
        return ans;
    }
}