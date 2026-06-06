package top.chenqwwq.leetcode.daily._2024._20241118;

/**
 * @author chenqwwq
 * @date 2024/11/18
 **/
public class Solution {

    int[][] move = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    public int[][] imageSmoother(int[][] img) {
        final int n = img.length, m = img[0].length;
        final int[][] ans = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int cur = img[i][j];
                int cnt = 1;
                for (int k = 0; k < 8; k++) {
                    int x = i + move[k][0], y = j + move[k][1];
                    if (x < 0 || x >= n || y < 0 || y >= m) continue;
                    cur += img[x][y];
                    cnt++;
                }
                ans[i][j] = cur / cnt;
            }
        }
        return ans;
    }
}