package top.chenqwwq.leetcode.weekly._305._2;

import sun.util.resources.cldr.zh.CalendarData_zh_Hans_HK;

import java.util.*;

/**
 * @author chenqwwq
 * @date 2022/8/7
 **/
public class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Set<Integer> vis = new HashSet<>();
        for (int re : restricted) {
            vis.add(re);
        }
        for (int[] edge : edges) {
            Set<Integer> s1 = graph.getOrDefault(edge[0], new HashSet<>());
            Set<Integer> s2 = graph.getOrDefault(edge[1], new HashSet<>());
            s1.add(edge[1]);
            s2.add(edge[0]);
            graph.put(edge[0], s1);
            graph.put(edge[1], s2);
        }
        int ans = 0;
        Deque<Integer> deque = new LinkedList<>();
        deque.push(0);
        vis.add(0);
        while (!deque.isEmpty()) {
            ans++;
            Integer cur = deque.pollFirst();
            for (int i : graph.getOrDefault(cur, new HashSet<>())) {
                if (vis.contains(i)) {
                    continue;
                }
                deque.push(i);
                vis.add(i);
            }
        }
        return ans;
    }
}