package top.chenqwwq.leetcode.daily._2026._20260118;

/**
 * @author chenqwwq
 * @date 2026/1/18
 **/
public class Solution {
    public int largestMagicSquare(int[][] grid) {
        int ans = 0;
        final int n = grid.length, m = grid[0].length;
        int[][] vs = new int[n][m];      // 水平
        int[][] hs = new int[n][m];      // 竖直

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                vs[i][j] = (j > 0 ? vs[i][j - 1] : 0) + grid[i][j];
                hs[i][j] = (i > 0 ? vs[i - 1][j] : 0) + grid[i][j];
            }
        }

        // 枚举左上角 坐标
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 枚举长度
                inner:
                for (int k = 2; k + i < n && k + j < m; k++) {
                    // 是否符合
                    int t = vs[i][j + k] - (j > 0 ? vs[i][j - 1] : 0);
                    int a = 0, b = 0;
                    // 横竖是否符合
                    for (int l = 0; l < k; l++) {
                        if (t != vs[i + l][j + k] - (j > 0 ? vs[i + l][j - 1] : 0)
                                || (t != hs[i + k][j] - (i > 0 ? hs[i - 1][j] : 0))) {
                            continue inner;
                        }
                    }
                }
            }
        }

        return 1;
    }
}