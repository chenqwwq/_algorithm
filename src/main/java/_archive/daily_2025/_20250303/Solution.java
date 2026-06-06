package top.chenqwwq.leetcode.daily._2025._20250303;

/**
 * @author chenqwwq
 * @date 2025/3/4
 **/
public class Solution {
    public int palindromePartition(String s, int k) {
        final char[] cs = s.toCharArray();
        final int n = s.length();

        int[][] minCost = new int[n][n];
        for (int i = n - 1; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                minCost[i][j] = minCost[i + 1][j - 1] + (cs[i] != cs[j] ? 1 : 0);
            }
        }
        return -1;
    }
}