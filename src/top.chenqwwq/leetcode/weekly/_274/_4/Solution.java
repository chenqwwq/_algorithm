package top.chenqwwq.leetcode.weekly._274._4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenbingxin
 * @date 2022/1/2
 **/
public class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();

    int n;
    boolean[] vis;
    int[] steps;
    int ans = 0;

    public int maximumInvitations(int[] favorite) {
        n = favorite.length;
        vis = new boolean[n];
        steps = new int[n];
        for (int i = 0; i < n; i++) {
            final List<Integer> orDefault = map.getOrDefault(favorite[i], new ArrayList<>());
            orDefault.add(i);
            map.put(favorite[i], orDefault);
        }
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(i, 0);
            }
        }
        return ans;
    }

    public void dfs(int start, int step) {
        vis[start] = true;
        steps[start] = step;
        if (step >= 2) {
            ans = Math.max(3, ans);
        }
        final List<Integer> nexts = map.get(start);
        if (nexts == null) {
            return;
        }
        for (int next : nexts) {
            if (!vis[next]) {
                dfs(next, step + 1);
            } else {
                final int len = steps[start] - steps[next] + 1;
                ans = Math.max(ans, len);
            }
        }
    }
}
