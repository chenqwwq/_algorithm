package top.chenqwwq.leetcode.contest.weekly._410._2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenqwwq
 * @date 2024/8/11
 **/
public class Solution {

    Map<Integer, List<Integer>> map;

    int ans = 0;

    public int countGoodNodes(int[][] edges) {
        map = new HashMap<>();
        for (int[] edge : edges) {
            final List<Integer> next = map.getOrDefault(edge[0], new ArrayList<>());
            next.add(edge[1]);
            map.put(edge[0], next);

            final List<Integer> next1 = map.getOrDefault(edge[1], new ArrayList<>());
            next1.add(edge[0]);
            map.put(edge[1], next1);
        }
        dfs(-1, 0);
        return ans;
    }


    public int dfs(int pre, int cur) {
        if (!map.containsKey(cur)) {
            ans++;
            return 1;
        }
        final List<Integer> nexts = map.get(cur);
        int total = 1, cnt = -1;
        boolean valid = true;
        for (int next : nexts) {
            if(next == pre) continue;
            final int dfs = dfs(cur,next);
            if (cur == 0) System.out.printf("%d,", dfs);
            if (cnt == -1) cnt = dfs;
            else if (cnt != dfs) valid = false;
            total += dfs;
        }
        if (valid) ans++;
        return total;
    }
}