package top.chenqwwq.leetcode.daily._2024._20241001;

import java.util.Arrays;

/**
 * @author chenqwwq
 * @date 2024/10/1
 **/
public class Solution {

    int INF = 0x3f3f3f3f;
    int N = 366;


    public int mincostTickets(int[] days, int[] costs) {
        final int n = days.length;
        memo = new int[N];
        Arrays.fill(memo, INF);
        ds = new boolean[N];
        for (int day : days) ds[day] = true;
        cs = costs;

        return dfs(days[n - 1]);
    }

    int[] memo;
    boolean[] ds;
    int[] cs;

    public int dfs(int i) {
        if (i <= 0) return 0;
        if (memo[i] != INF) return memo[i];
        if (!ds[i]) return memo[i] = dfs(i - 1);
        memo[i] = dfs(i - 1) + cs[0];
        memo[i] = Math.min(memo[i], dfs(i - 7) + cs[1]);
        memo[i] = Math.min(memo[i], dfs(i - 30) + cs[2]);
        return memo[i];
    }
}