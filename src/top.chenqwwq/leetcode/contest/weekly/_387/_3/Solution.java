package top.chenqwwq.leetcode.contest.weekly._387._3;

import java.util.Map;

/**
 * @author chenqwwq
 * @date 2024/3/3
 **/
public class Solution {
    public static void main(String[] args) {
        new Solution().minimumOperationsToWriteY(new int[][]{
                {1, 2, 2},
                {1, 1, 0},
                {0, 1, 0}});
    }

    public int minimumOperationsToWriteY(int[][] grid) {
        final int n = grid.length, m = n >> 1;
        int[] cy = new int[3], ncy = new int[3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == j && i <= m) || (i + j == n - 1 && j >= m) || (j == m && i >= m)) {
                    cy[grid[i][j]]++;
                } else {
                    ncy[grid[i][j]]++;
                }
            }
        }
        int cyc = 0, ncyc = 0;
        for (int c : cy) cyc += c;
        for (int c : ncy) ncyc += c;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                if (i == j) continue;
                ans = Math.min(ans, cyc - cy[i] + ncyc - ncy[j]);
            }
        }
        return ans;
    }
}