package top.chenqwwq.leetcode.contest.weekly._390._2;

/**
 * @author chenqwwq
 * @date 2024/3/24
 **/
public class Solution {
    private static final int INF = 0x3f3f3f3f;

    public int minOperations(int k) {
        int ans = INF;
        for (int i = 1; i <= k; i++) {
            ans = Math.min(ans, i - 1 + (k / i) - 1 + (k % i == 0 ? 0 : 1));
        }
        return ans == INF ? 0 : ans;
    }
}