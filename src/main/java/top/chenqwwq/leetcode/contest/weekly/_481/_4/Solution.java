package top.chenqwwq.leetcode.contest.weekly._481._4;

import java.util.*;

/**
 * @author chenqwwq
 * @date 2025/12/22
 **/
public class Solution {
    public static void main(String[] args) {
        final Solution solution = new Solution();
        final long l = solution.interactionCosts(3, new int[][]{{0, 1}, {1, 2}}, new int[]{3, 2, 3});
        System.out.println(l);
    }

    long ans = 0;

    public long interactionCosts(int n, int[][] edges, int[] group) {
        // 树肯定没有环
        // 以 0作为根节点

        ans = 0;

        //  预处理图
        final Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.merge(edge[0], List.of(edge[1]), (a, b) -> {
                List<Integer> ret = new ArrayList<>();
                ret.addAll(a);
                ret.addAll(b);
                return ret;
            });
            graph.merge(edge[1], List.of(edge[0]), (a, b) -> {
                List<Integer> ret = new ArrayList<>();
                ret.addAll(a);
                ret.addAll(b);
                return ret;
            });
        }

        // 预处理组合
        Map<Integer, Set<Integer>> comb = new HashMap<>();
        for (int i = 0; i < group.length; i++) {
            comb.merge(group[i], Set.of(i), (a, b) -> {
                Set<Integer> ret = new HashSet<>();
                ret.addAll(a);
                ret.addAll(b);
                return ret;
            });
        }

        // 计算每个子树的出度（就是这条边的贡献次数
        dfs(graph, 0, -1, comb, group);
        return ans >> 1;
    }


    public Set<Integer> dfs(Map<Integer, List<Integer>> graph, int cur, int parent, Map<Integer, Set<Integer>> comb, int[] group) {
        final Set<Integer> vis = new HashSet<>();

        final List<Integer> nexts = graph.getOrDefault(cur, new ArrayList<>());
        for (int next : nexts) {
            if (parent == next) continue;
            final Set<Integer> childs = dfs(graph, next, cur, comb, group);
            vis.addAll(childs);
        }


        // 判断同组元素是否在本子树
        for (int next : nexts) {
            // 同个组的所有元素
            final Set<Integer> sg = comb.get(group[next]);
            //  求和同组元素的交集
            final Set<Integer> sets = new HashSet<>();
            sets.addAll(sg);
            sets.retainAll(vis);
            ans += sg.size() - sets.size();
        }

        vis.add(cur);
        return vis;
    }
}