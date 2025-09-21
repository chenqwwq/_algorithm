package top.chenqwwq.leetcode.contest.weekly._324._3;

import java.util.*;

/**
 * @author chenqwwq
 * @date 2022/12/18
 **/
public class Solution {
    public boolean isPossible(int n, List<List<Integer>> edges) {
        int[] degree = new int[n + 1];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (List<Integer> edge : edges) {
            int a = edge.get(0), b = edge.get(1);
            degree[a]++;
            degree[b]++;
            if (!map.containsKey(a)) map.put(a, new HashSet<>());
            if (!map.containsKey(b)) map.put(b, new HashSet<>());
            map.get(a).add(b);
            map.get(b).add(a);
        }

        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if ((degree[i] & 1) == 0) continue;
            nums.add(i);
        }

        return false;

    }
}