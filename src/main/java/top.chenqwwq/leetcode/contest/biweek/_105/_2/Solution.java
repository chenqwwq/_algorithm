package top.chenqwwq.leetcode.contest.biweek._105._2;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author 沽酒
 * @since 2023/05/29
 */
public class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        final int n = s.length();
        Set<String> ss = new HashSet<>();
        Collections.addAll(ss, dictionary);

        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = i + 1;
            for (int j = i; j >= 0; j--) {
                dp[i] = Math.min(dp[i], ss.contains(s.substring(j, i+1)) ? (j > 0 ? dp[j-1] : 0 ) :(j > 0 ? dp[j-1] : 0 ) + i - j + 1);
            }
        }
        return dp[n-1];
    }
}