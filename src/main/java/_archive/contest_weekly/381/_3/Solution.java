package top.chenqwwq.leetcode.contest.weekly._381._3;

import java.util.*;

/**
 * @author chenqwwq
 * @date 2024/1/21
 **/
public class Solution {


    public int minimumPushes(String word) {
        final int n = word.length();
        final int[] hash = new int[26];
        for (int i = 0; i < n; i++) hash[word.charAt(i) - 'a']++;
        Arrays.sort(hash);

        int cur = 1, cnt = 1;
        int ans = 0;
        for (int i = 25; i >= 0; i--) {
            if (hash[i] <= 0) break;
            ans += cur * hash[i];
            if (++cnt > 8) {
                cur++;
                cnt = 1;
            }
        }
        return ans;
    }
}