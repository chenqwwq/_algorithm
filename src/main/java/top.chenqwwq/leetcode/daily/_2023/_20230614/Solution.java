package top.chenqwwq.leetcode.daily._2023._20230614;

/**
 * @author 沽酒
 * @since 2023/06/14
 */
public class Solution {
    public int numTimesAllBlue(int[] flips) {
        final int n = flips.length;
        boolean[] vis = new boolean[n + 1];
        int cur = 1, ans = 0;
        for (int i = 0; i < n; i++) {
            vis[flips[i]] = true;
            while (cur <= n && vis[cur]) cur++;
            if (cur > i + 1) ans++;
        }
        return ans;
    }
}