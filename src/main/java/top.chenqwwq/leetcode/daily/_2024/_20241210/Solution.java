package top.chenqwwq.leetcode.daily._2024._20241210;

import java.util.List;
import java.util.Map;

/**
 * @author chenqwwq
 * @date 2024/12/10
 **/
public class Solution {
    private static final int mod = 1000000007;

    private static final Map<Integer, List<Integer>> numAndNext;

    static {
        numAndNext = Map.of(
                1, List.of(6, 8),
                2, List.of(7, 9),
                3, List.of(4, 8),
                4, List.of(3, 9, 0),
                5, List.of(),
                6, List.of(1, 7, 0),
                7, List.of(2, 6),
                8, List.of(1, 3),
                9, List.of(2, 4),
                0, List.of(4, 6)
        );
    }

    long[][] dp;

    public int knightDialer(int n) {
        this.dp = new long[2][10];

        for (int i = 0; i < 10; i++) {
            dp[0][i] = 1;
        }
        int flag = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                dp[flag][j] = 0;
                final List<Integer> next = numAndNext.get(j);
                for (int k : next) {
                    dp[flag][j] = (dp[flag ^ 1][k] + dp[flag][j]) % mod;
                }
            }
            flag ^= 1;
        }
        long ans = 0;
        for (long num : dp[flag ^ 1]) {
            ans = (ans + num) % mod;
        }
        return (int) ans;
    }
}