package top.chenqwwq.leetcode.contest.biweek._93._2;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author chenqwwq
 * @date 2022/12/13
 **/
public class Solution {
    public int maxStarSum(int[] vals, int[][] edges, int k) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            add(map, vals, edge[0], edge[1], k);
            add(map, vals, edge[1], edge[0], k);
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < vals.length; i++) {
            int sum = vals[i];
            if(map.containsKey(i)) {
                final PriorityQueue<Integer> queue = map.get(i);
                while (!queue.isEmpty()) {
                    sum += queue.poll();
                }
            }
            ans = Math.max(ans,sum);
        }
        return ans;
    }

    private void add(Map<Integer, PriorityQueue<Integer>> map, int[] vals, int a, int b, int k) {
        if (!map.containsKey(a)) {
            map.put(a, new PriorityQueue<>());
        }
        final PriorityQueue<Integer> queue = map.get(a);
        if(vals[b] > 0) {
            queue.add(vals[b]);
            while (queue.size() > k) {
                queue.poll();
            }
        }
    }
}