package top.chenqwwq.leetcode.contest.weekly._348._3;

/**
 * @author chenqwwq
 * @date 2023/6/4
 **/
public class Solution {
    public long matrixSumQueries(int n, int[][] queries) {
        final int m = queries.length;
        long ans = 0;
        long h = 0, v = 0;
        boolean[][] vis = new boolean[2][n];

        for (int i = m - 1; i >= 0; i--) {
            if (vis[queries[i][0]][queries[i][1]]) continue;
            if (queries[i][0] == 0) {
                ans += (long) queries[i][2] * (n - h);
                v++;
            } else {
                ans += (long) queries[i][2] * (n - v);
                h++;
            }
            vis[queries[i][0]][queries[i][1]] = true;
        }
        return ans;
    }
}