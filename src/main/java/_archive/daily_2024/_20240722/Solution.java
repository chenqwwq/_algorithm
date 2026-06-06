package top.chenqwwq.leetcode.daily._2024._20240722;

/**
 * @author chenqwwq
 * @date 2024/7/22
 **/
public class Solution {
    int n;
    boolean[][] bs;


    public int maximumDetonation(int[][] bombs) {
        n = bombs.length;
        bs = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected(bombs[i], bombs[j])) {
                    bs[i][j] = true;
                }
                if (isConnected(bombs[j], bombs[i])) {
                    bs[j][i] = true;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            final boolean[] vis = new boolean[n];
            vis[i] = true;
            ans = Math.max(ans,  dfs(i, vis));
        }
        return ans;
    }

    private int dfs(int i, boolean[] vis) {
        int ans = 1;
        for (int j = 0; j < n; j++) {
            if (!vis[j] && bs[i][j]) {
                vis[j] = true;
                ans += dfs(j, vis);
            }
        }
        return ans;
    }

    public boolean isConnected(int[] a, int[] b) {
        long d = (long) (a[0] - b[0]) * (a[0] - b[0]) + (long) (a[1] - b[1]) * (a[1] - b[1]);
        return d <= (long) a[2] * a[2];
    }
}