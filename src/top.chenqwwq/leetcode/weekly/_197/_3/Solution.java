package top.chenqwwq.leetcode.weekly._197._3;

import java.util.HashSet;
import java.util.Set;

/**
 * 概率最大的路径
 * 题目难度Medium
 * 给你一个由 n 个节点（下标从 0 开始）组成的无向加权图，该图由一个描述边的列表组成，其中 edges[i] = [a, b] 表示连接节点 a 和 b 的一条无向边，且该边遍历成功的概率为 succProb[i] 。
 * <p>
 * 指定两个节点分别作为起点 start 和终点 end ，请你找出从起点到终点成功概率最大的路径，并返回其成功概率。
 * <p>
 * 如果不存在从 start 到 end 的路径，请 返回 0 。只要答案与标准答案的误差不超过 1e-5 ，就会被视作正确答案。
 *
 * @author chen
 * @date 2020/7/12 上午10:28
 */
public class Solution {

    public double res = Double.MIN_VALUE;

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        double[][] graph = new double[n][n];
        for (int i = 0; i < edges.length; i++) {
            graph[edges[i][0]][edges[i][1]] = succProb[i];
            graph[edges[i][1]][edges[i][0]] = succProb[i];
        }

        dfs(graph, start, end, 1, new HashSet<>());
        return res == Double.MIN_VALUE ? 0 : res;
    }

    public void dfs(double[][] graph, int start, int end, double curr, Set<Integer> road) {
        if (start == end) {
            res = Math.max(curr, res);
            return;
        }

        if (road.contains(start)) {
            return;
        }

        road.add(start);
        for (int i = 0; i < graph.length; i++) {
            if (graph[start][i] > 0) {
                dfs(graph, i, end, curr * graph[start][i], road);
            }
        }
        road.remove(start);
    }
}
