package top.chenqwwq.leetcode.daily._20210504;

import java.util.Arrays;

/**
 * @author chen
 * @date 2021/5/4
 **/
public class Solution {
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        // dp[i][j][k]
        // i 表示房子,j 表示颜色,k 表示分为了几个街区([0,i]的房子)

        int[][][] costs = new int[m][n + 1][target + 1];

        // 初始数据
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <= n; j++) {
                Arrays.fill(costs[i][j], Integer.MAX_VALUE);
            }
        }
        // 初始第一座房子,可能已经上色也可能还没有上色
        for (int i = 1; i <= n; i++) {
            if (houses[0] == 0) {
                costs[0][i][1] = cost[0][i - 1];
            } else if (houses[0] == i) {
                costs[0][i][1] = 0;
            }
        }

        // 第几个房屋
        for (int i = 1; i < m; i++) {
            // 颜色未定
            if (houses[i] == 0) {
                // 哪种颜色
                for (int j = 1; j <= n; j++) {
                    // 分了几个街区
                    for (int k = 1; k <= target; k++) {
                        // 达到k个的标准
                        // 1. 和前面的颜色保持一致,街区维持在k个不变
                        // 2. 和前面的颜色不一致，街区+1

                        int tc = Integer.MAX_VALUE;
                        // 颜色保持一致的
                        for (int q = 1; q <= n; q++) {
                            if (q == j) {
                                if (costs[i - 1][q][k] != Integer.MAX_VALUE) {
                                    tc = Math.min(costs[i - 1][q][k] + cost[i][j - 1], tc);
                                }
                            } else if (costs[i - 1][q][k - 1] != Integer.MAX_VALUE) {
                                tc = Math.min(costs[i - 1][q][k - 1] + cost[i][j - 1], tc);
                            }
                        }

                        costs[i][j][k] = tc;
                    }
                }
            } else {
                // 分了几个街区
                // 当前房屋的颜色
                final int colour = houses[i];
                for (int k = 1; k <= target; k++) {
                    int tc = Integer.MAX_VALUE;
                    // 颜色保持一致的
                    for (int q = 1; q <= n; q++) {
                        if (q == colour) {
                            if (costs[i - 1][q][k] != Integer.MAX_VALUE) {
                                tc = Math.min(costs[i - 1][q][k], tc);
                            }
                        } else if (costs[i - 1][q][k - 1] != Integer.MAX_VALUE) {
                            tc = Math.min(costs[i - 1][q][k - 1], tc);
                        }
                    }

                    costs[i][colour][k] = tc;
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            if (costs[m - 1][i][target] != Integer.MAX_VALUE) {
                ans = Math.min(costs[m - 1][i][target], ans);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}