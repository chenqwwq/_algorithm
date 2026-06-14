package top.chenqwwq.leetcode.daily._2026._20260612;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int assignEdgeWeights(int[][] edges) {
        final int n = edges.length;
        // 先建树
        Map<Integer, List<Integer>> tree = new HashMap<>();
        for (int[] edge : edges) {
            List<Integer> next = tree.getOrDefault(edge[0], new ArrayList<>());
            next.add(edge[1]);
            tree.put(edge[0], next);
            List<Integer> next1 = tree.getOrDefault(edge[1], new ArrayList<>());
            next.add(edge[0]);
            tree.put(edge[1], next1);
        }

        // 找到最大深度
        dfs(new boolean[n + 1], tree, n, ml);
        return (int) Math.pow(2, ml - 1);
    }

    int ml = -1;

    private void dfs(boolean[] vis, Map<Integer, List<Integer>> tree, int cur, int level) {
        vis[cur] = true;
        ml = Math.max(ml, level);
        for (Integer next : tree.get(cur)) {
            if (vis[next])
                continue;
            vis[next] = true;
            dfs(vis, tree, cur, level + 1);
        }
    }
}