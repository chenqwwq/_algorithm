package top.chenqwwq.leetcode.daily._2024._20240305;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author chenqwwq
 * @date 2024/3/5
 **/
public class Solution {

    final long inf = Long.MAX_VALUE / 2;
    private static final int mod = (int) 1e9 + 7;

    public int countPaths(int n, int[][] roads) {
        // 构造图
        final long[][] graph = new long[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(graph[i], inf);
        for (int[] road : roads) {
            graph[road[0]][road[1]] = graph[road[1]][road[0]] = road[2];
        }
        graph[0][0] = 0;

        // 0到各个点的距离
        final long[] dis = new long[n];
        Arrays.fill(dis, inf);
        dis[0] = 0;
        // 是否访问过
        final boolean[] vis = new boolean[n];
        // 0各个点的方案数
        final long[] cnt = new long[n];
        cnt[0] = 1L;

        for (int i = 1; i < n; i++) {
            // 选择当前距离最近并且没有访问过的节点
            int t = -1;
            for (int j = 0; j < n; j++) {
                if (!vis[j] && (t == -1 || dis[j] < dis[t])) {
                    t = j;
                }
            }
            vis[t] = true; // 标记已经访问过

            // 根据 dist[t] 更新后续节点
            for (int k = 0; k < n; k++) {
                if (k == t) continue;
                long dt = dis[t] + graph[t][k];
                if (dt < dis[k]) {
                    dis[k] = dt;
                    cnt[k] = cnt[t];
                } else if (dt == dis[k]) {
                    cnt[k] = (cnt[k] + cnt[t]) % mod;
                }
            }
        }
        return (int) cnt[n - 1];

    }
}