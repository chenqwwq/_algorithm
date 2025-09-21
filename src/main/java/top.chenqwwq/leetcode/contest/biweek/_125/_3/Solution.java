package top.chenqwwq.leetcode.contest.biweek._125._3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenqwwq
 * @date 2024/3/2
 **/
public class Solution {
    Map<Integer, Map<Integer, Integer>> map;
    int ss;

    public int[] countPairsOfConnectableServers(int[][] edges, int signalSpeed) {
        // 树无环
        final int n = edges.length + 1;
        map = new HashMap<>();
        ss = signalSpeed;
        for (int[] edge : edges) {
            final int l = edge[0], r = edge[1], w = edge[2];
            final Map<Integer, Integer> lm = map.getOrDefault(l, new HashMap<>());
            final Map<Integer, Integer> rm = map.getOrDefault(r, new HashMap<>());
            lm.put(r, w);
            rm.put(l, w);
            map.put(l, lm);
            map.put(r, rm);
        }

        final int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = handle(i);
        }
        return ans;
    }

    public int handle(int i) {
        final Map<Integer, Integer> nexts = map.getOrDefault(i, new HashMap<>());
        if (nexts.isEmpty() || nexts.size() < 2) return 0;
        List<Integer> ls = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : nexts.entrySet()) {
            ls.add(handle(i, entry.getKey(), entry.getValue()));
        }
        int ans = 0;
        for (int a = 0; a < ls.size(); a++) {
            for (int b = a + 1; b < ls.size(); b++) {
                ans += ls.get(a) * ls.get(b);
            }
        }
        return ans;
    }

    public int handle(int pre, int i, int cur) {
        int ans = cur % ss == 0 ? 1 : 0;
        final Map<Integer, Integer> nexts = map.getOrDefault(i, new HashMap<>());
        for (Map.Entry<Integer, Integer> next : nexts.entrySet()) {
            if (next.getKey() == pre) continue;
            ans += handle(i, next.getKey(), cur + next.getValue());
        }
        return ans;
    }
}