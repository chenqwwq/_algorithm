package top.chenqwwq.leetcode.contest.weekly._421._2;

/**
 * @author chenqwwq
 * @date 2024/10/27
 **/
public class Solution {

    private static final int MOD = (int) (1e9 + 7);

    private final long[] memo = new long[10027];

    public int lengthAfterTransformations(String s, int t) {
        final char[] cs = s.toCharArray();
        long ans = 0;
        for (char c : cs) {
            ans = (ans + getA(t + (c - 'a'))) % MOD;
        }
        return (int) (ans % MOD);
    }


    // 求 Z 在经历了 t 次变化后字符串长度
    public long getA(int t) {
        if (t <= 25) return 1;
        if (memo[t] != 0) return memo[t];
        return (memo[t] = (((getA(t - 25)) + getA(t - 24))) % MOD);
    }
}