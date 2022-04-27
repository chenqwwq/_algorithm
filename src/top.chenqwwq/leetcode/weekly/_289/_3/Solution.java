package top.chenqwwq.leetcode.weekly._289._3;

import javax.jws.soap.SOAPBinding;

/**
 * @author chenqwwq
 * @date 2022/4/17
 **/
public class Solution {
    int[] size = new int[]{10, 5, 2};
    public int maxTrailingZeros(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][][] hash = new int[3][n][m];
        int[][][] p1 = new int[3][n][m], p2 = new int[3][n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int q = 0; q < 3; q++) {
                    while (grid[i][j] % size[q] == 0) {
                        hash[q][i][j]++;
                        grid[i][j] /= size[q];
                    }
                    p1[q][i][j] = hash[q][i][j] + (i > 0 ? p1[q][i - 1][j] : 0);
                    p2[q][i][j] = hash[q][i][j] + (j > 0 ? p2[q][i][j - 1] : 0);
                }
            }
        }
        int ans = 0;
        int[][] a1 = new int[3][2], a2 = new int[3][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int q = 0; q < 3; q++) {
                    a1[q][0] = p1[q][i][j];
                    a1[q][1] = p1[q][n - 1][j] - (i > 0 ? p1[q][i - 1][j] : 0);
                    a2[q][0] = j > 0 ? p2[q][i][j - 1] : -1;
                    a2[q][1] = p2[q][i][m - 1] - p2[q][i][j];
                }
                for (int x = 0; x < 2; x++) {
                    for (int y = 0; y < 2; y++) {
                        int ten = a1[0][x] + a2[0][y];
                        int five = a1[1][x] + a2[1][y];
                        int two = a1[2][x] + a2[2][y];
                        ans = Math.max(ans, ten + Math.min(five, two));
                    }
                }
            }
        }
        return ans;
    }
}