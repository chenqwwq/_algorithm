package top.chenqwwq.leetcode.contest.biweek._145._2;

import java.util.*;

/**
 * @author chenqwwq
 * @date 2024/12/11
 **/
public class Solution {

    int[] memo;     // memo[i] 表示状态为 i 的最小时间
    int n, k;


    public int findMinimumTime(List<Integer> strength, int K) {
        this.n = strength.size();
        this.k = K;
        // 记忆化递归
        this.memo = new int[1 << n];
        Arrays.fill(memo, -1);
        // 二进制表示状态
        return dfs((1 << n) - 1, strength.toArray(new Integer[0]));
    }

    private int dfs(int status, Integer[] ss) {
        if (status == 0) return 0;
        if (memo[status] != -1) return memo[status];
        int res = Integer.MAX_VALUE;
        // 目前的递增量
        int x = 1 + k * (n - Integer.bitCount(status));

        // 遍历每一位
        for (int j = 0; j < n; j++) {
            // 是否包含当前位
            if ((status >> j & 1) <= 0) continue;
            // 去除当前位的状态
            res = Math.min(res, dfs(status ^ (1 << j), ss) + (ss[j] - 1) / x + 1);
        }
        return memo[status] = res;
    }
}