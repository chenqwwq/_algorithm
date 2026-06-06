package top.chenqwwq.leetcode.contest.weekly._502._3;

/**
 * @author chenqwwq
 * @date 2026/5/17
 **/
public class Solution {
    public int countLocalMaximums(int[][] matrix) {
        final int n = matrix.length, m = matrix[0].length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            loop:
            for (int j = 0; j < m; j++) {
                int v = matrix[i][j];
                if (v <= 0) continue;
                for (int x = -v; x <= v; x++) {
                    for (int y = -v; y <= v; y++) {
                        if (Math.abs(x) == v && Math.abs(y) == v) continue;
                        int xx = i + x, yy = j + y;
                        if (xx < 0 || xx >= n || yy < 0 || yy >= m) continue;
                        if (matrix[xx][yy] > v) continue loop;
                    }
                }
                ans++;
            }
        }
        return ans;
    }
}