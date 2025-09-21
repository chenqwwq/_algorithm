package top.chenqwwq.leetcode.contest.weekly._377._3;

/**
 * @author chenqwwq
 * @date 2023/12/24
 **/
public class Solution {

    private static final int INF = 0x3f3f3f3f;

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int[][] map = new int[26][26];
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                map[i][j] = i == j ? 0 : INF;
            }
        }
        final int k = original.length, n = source.length();
        for (int i = 0; i < k; i++) {
            final int x = original[i] - 'a';
            final int y = changed[i] - 'a';
            map[x][y] = Math.min(cost[i], map[x][y]);
        }
        floyd(map);
        long ans = 0;
        for (int i = 0; i < n; i++) {
            final int s = source.charAt(i) - 'a', t = target.charAt(i) - 'a';
            if(map[s][t] == INF) return -1;
            ans += map[s][t];
        }
        return ans;
    }

    private void floyd(int[][] g) {
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