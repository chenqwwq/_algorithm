package top.chenqwwq.leetcode.daily._2023._20230716;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntFunction;

/**
 * @author chenqwwq
 * @date 2023/7/16
 **/
public class Solution {
    private List<Integer>[] graph;
    private int[] ans, size;
    private int n;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        // 构造树
        this.n = n;
        graph = new ArrayList[n];
        ans = new int[n];
        size = new int[n];
        Arrays.setAll(graph, e -> new ArrayList<>());
        for (var e : edges) {
            int a = e[0], b = e[1];
            graph[a].add(b);
            graph[b].add(a);
        }
        dfs(0, -1, 0);
        reroot(0, -1);
        return ans;
    }

    public void dfs(int root, int parent, int dep) {
        ans[0] += dep;
        size[root] = 1;
        for (int next : graph[root]) {
            if (next == parent) continue;
            dfs(next, root, dep + 1);
            size[root] += size[next];
        }
    }


    public void reroot(int root, int parent) {
        // 换根dp
        for (var next : graph[root]) {
            if (next == parent) continue;
            ans[next] = ans[root] + n - size[next] - size[next];
            reroot(next, root);
        }
    }
}