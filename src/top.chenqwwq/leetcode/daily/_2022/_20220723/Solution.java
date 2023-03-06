package top.chenqwwq.leetcode.daily._2022._20220723;


import java.util.*;

/**
 * @author chenqwwq
 * @date 2022/7/23
 **/
public class Solution {
    public boolean sequenceReconstruction(int[] nums, int[][] seq) {
        final int n = nums.length;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] id = new int[n + 1];
        for (int[] sq : seq) {
            for (int i = 1; i < sq.length; i++) {
                if (!graph.containsKey(sq[i-1])) {
                    graph.put(sq[i-1], new ArrayList<>());
                }
                graph.get(sq[i-1]).add(sq[i]);
                id[sq[i]]++;
            }
        }

        Deque<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (id[i] == 0) {
                deque.add(i);
            }
        }
        int cnt = 0;
        while (!deque.isEmpty()) {
            cnt++;
            if (deque.size() != 1) {
                return false;
            }
            int fir = deque.pollFirst();
            for (int next : graph.getOrDefault(fir, new ArrayList<>())) {
                if (--id[next] == 0) {
                    deque.add(next);
                }
            }
        }
        return cnt == n;
    }
}