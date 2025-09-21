package top.chenqwwq.leetcode.contest.biweek._91._3;

import java.util.*;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author chenqwwq
 * @date 2022/11/14
 **/
public class Solution {
    private static final int INF = 0x3f3f3f3f;
    Map<Integer, Integer> bobTimes;
    Map<Integer, Set<Integer>> map;
    Set<Integer> root;
    int[] amount;
    int bob;

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        this.root = new HashSet<>();
        this.amount = amount;
        this.bobTimes = new HashMap<>();
        this.bobTimes.put(bob, 0);
        this.map = new HashMap<>();
        this.bob = bob;
        // 建图
        for (var edge : edges) {
            int a = edge[0], b = edge[1];
            // 因为没有固定的方向，只能暂定为无向图
            if (!map.containsKey(a)) map.put(a, new HashSet<>());
            map.get(a).add(b);
            if (!map.containsKey(b)) map.put(b, new HashSet<>());
            map.get(b).add(a);
        }

        // 计算 bob 路径上各个节点的到达时间
        bobTimes.put(bob, 0);
        dfs2(0, -1);
        return dfs(0, amount[0], 1,-1);
    }

    private int dfs2(int cur, int parent) {
        int ret = -1;
        if (cur == bob) ret = 0;
        Set<Integer> nexts = map.get(cur);
        int num;
        boolean isRoot = true;
        for (int next : nexts) {
            if (next == parent) continue;
            isRoot = false;
            if ((num = dfs2(next, cur)) != -1) {
                bobTimes.put(cur, num + 1);
                ret = num + 1;
            }
        }
        if (isRoot) root.add(cur);
        return ret;
    }

    private int dfs(int cur, int sum, int step, int parent) {
        if (root.contains(cur)) return sum;
        Set<Integer> nexts = map.get(cur);
        int max = -INF;
        for (int next : nexts) {
            if (next == parent) continue;
            ;
            int bobTime = bobTimes.getOrDefault(next, INF);
            if (step < bobTime) max = Math.max(dfs(next, sum + amount[next], step + 1, cur), max);
            else if (step == bobTime) max = Math.max(max, dfs(next, sum + (amount[next] >> 1), step + 1, cur));
            else max = Math.max(max, dfs(next, sum, step + 1, cur));
        }
        return max;
    }
}