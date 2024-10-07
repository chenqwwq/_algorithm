package top.chenqwwq.leetcode.daily._2024._20241003;

import java.util.*;

/**
 * @author chenqwwq
 * @date 2024/10/3
 **/
class Solution {

    int INF = 0x3f3f3f3f;
    int N;
    int[] memo;     // memo[i] 表示 i->n 的最小费用,初始化 memo[n-1] = fees[n-1]

    public int minCost(int maxTime, int[][] edges, int[] passingFees) {

        N = passingFees.length;
        memo = new int[N];
        Arrays.fill(memo, INF);
        memo[N - 1] = passingFees[N - 1];

        final Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : edges) {
            final List<int[]> o1 = graph.getOrDefault(edge[0], new ArrayList<>());
            final List<int[]> o2 = graph.getOrDefault(edge[1], new ArrayList<>());
            o1.add(new int[]{edge[1], edge[2]});
            o2.add(new int[]{edge[0], edge[2]});
            graph.put(edge[0], o1);
            graph.put(edge[1], o2);
        }

        final boolean[] vis = new boolean[N];
        vis[0] = true;
        dfs(graph, 0, passingFees, vis, maxTime);
        return memo[0] == INF ? -1 : memo[0];
    }

    public int dfs(Map<Integer, List<int[]>> graph, int cur, int[] fees, boolean[] vis, int mt) {
        if (memo[cur] != INF) return memo[cur];
        int ans = INF;
        for (int[] next : graph.getOrDefault(cur, Collections.emptyList())) {
            if (vis[next[0]]) continue;
            if (mt - next[1] < 0) continue;
            vis[next[0]] = true;
            final int dfs = dfs(graph, next[0], fees, vis, mt - next[1]);
            if (dfs == INF) continue;
            ans = Math.min(ans, dfs+fees[cur]);
            vis[next[0]] = false;
        }
        return memo[cur] = ans;
    }

    public static void main(String[] args) {
        new Solution().minCost(30, new int[][]{{0,1,10},{1,2,10},{2,5,10},{0,3,1},{3,4,10},{4,5,15}}, new int[]{5, 1, 2, 20, 20, 3});
    }
}