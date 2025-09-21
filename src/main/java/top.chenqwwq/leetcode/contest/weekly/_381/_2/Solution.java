package top.chenqwwq.leetcode.contest.weekly._381._2;

import java.util.Arrays;

/**
 * @author chenqwwq
 * @date 2024/1/21
 **/
public class Solution {
    private static final int INF = 0x3f3f3f3f;

    public int[] countOfPairs(int n, int x, int y) {
        final int[][] g = new int[n][n];
        for(int i = 0;i < n;i++) Arrays.fill(g[i],INF);
        for (int i = 0; i < n - 1; i++) g[i][i + 1] = g[i + 1][i] = 1;
        if (Math.abs(x - y) != 1) g[x - 1][y - 1] = g[y - 1][x - 1] = 1;
        floyd(g);
        final int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                ans[g[i][j] - 1]++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        new Solution().countOfPairs(5, 2, 4);
    }

    public void floyd(int[][] g) {
        int n = g.length;
        // floyd 基本流程为三层循环: [枚举中转点 - 枚举起点 - 枚举终点] => 松弛操作

        // 外层为中间节点
        for (int p = 0; p < n; p++) {
            // 中间为起点
            for (int i = 0; i < n; i++) {
                // 内层为终点
                for (int j = 0; j < n; j++) {
                    g[i][j] = Math.min(g[i][j], g[i][p] + g[p][j]);
                }
            }
        }
    }
}