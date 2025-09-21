package top.chenqwwq.leetcode.unkown.sf_tech._2;

/**
 * @author 沽酒
 * @since 2022/06/30
 */
public class Solution {
    public int minRemainingSpace(int[] N, int V) {
        int[] dp = new int[V + 1];
        for (int n : N) {
            for (int i = V; i >= n; i--) {
                dp[i] = Math.max(dp[i], dp[i - n] + n);
            }
        }
        return V - dp[V];
    }
}