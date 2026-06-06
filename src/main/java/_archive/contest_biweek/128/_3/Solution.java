package top.chenqwwq.leetcode.contest.biweek._128._3;

import java.util.*;

/**
 * @author chenqwwq
 * @date 2024/4/14
 **/
public class Solution {

    private static final int INF = 0x3f3f3f3f;
    Map<Integer, Map<Integer, Integer>> g;
    int[] disappear;

    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        this.g = new HashMap<>();
        this.disappear = disappear;

        // 构造图
        for (int[] edge : edges) {
            g.compute(edge[0], (key, ov) -> {
                if (ov == null) ov = new HashMap<>();
                ov.put(edge[1], Math.min(edge[2], ov.getOrDefault(edge[1], INF)));
                return ov;
            });
            g.compute(edge[1], (key, ov) -> {
                if (ov == null) ov = new HashMap<>();
                ov.put(edge[0], Math.min(edge[2], ov.getOrDefault(edge[0], INF)));
                return ov;
            });
        }

        // 源点到每个点的位置
        final int[] ans = new int[n];
        Arrays.fill(ans, -1);
        ans[0] = 0;

        final PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        queue.offer(new int[]{0, 0});
        while (!queue.isEmpty()) {
            // 弹出目前离源点距离最短的点和经过的时间
            final int[] poll = queue.poll();
            int cur = poll[0], dis = poll[1];
            if (dis > ans[cur]) continue;
            for (Map.Entry<Integer, Integer> entry : g.getOrDefault(cur, new HashMap<>()).entrySet()) {
                int next = entry.getKey(), value = entry.getValue();
                // 节点已经消失
                if (disappear[next] <= value + poll[1]) continue;
                // 距离更新
                if (ans[next] == -1 || ans[next] > poll[1] + value) {
                    ans[next] = poll[1] + value;
                    queue.offer(new int[]{next, ans[next]});
                }
            }
        }
        return ans;
    }
}