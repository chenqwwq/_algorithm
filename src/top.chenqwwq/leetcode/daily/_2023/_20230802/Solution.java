package top.chenqwwq.leetcode.daily._2023._20230802;

import java.util.HashSet;
import java.util.Map;

/**
 * @author chenqwwq
 * @date 2023/8/2
 **/
public class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        final int n = fronts.length;
        boolean[] vis = new boolean[2001];
        for (int i = 0; i < n; i++) {
            if (fronts[i] == backs[i]) vis[backs[i]] = true;
        }
        int ans = 1001;
        for (int i = 0; i < n; i++) {
            if (backs[i] == fronts[i]) continue;
            if (!vis[backs[i]]) ans = Math.min(ans, backs[i]);
            if (!vis[fronts[i]]) ans = Math.min(ans, fronts[i]);
        }
        return ans == 1001 ? 0 : ans;
    }
}