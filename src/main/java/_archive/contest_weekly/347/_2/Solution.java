package top.chenqwwq.leetcode.contest.weekly._347._2;

import java.util.Arrays;

/**
 * @author 沽酒
 * @since 2023/05/30
 */
public class Solution {
    public int[][] differenceOfDistinctValues(int[][] grid) {
        final int n = grid.length, m = grid[0].length;
        int[][] ans = new int[n][m];

        int[] hash = new int[51], hash1 = new int[51];
        for (int i = 0; i < n; i++) {
            Arrays.fill(hash, 0);
            Arrays.fill(hash1, 0);
            int right = 0;
            for (int x = i, y = 0; x < n && y < m; x++, y++) {
                if (++hash[grid[x][y]] == 1) right++;
            }
            int left = 0;
            for (int x = i, y = 0; x < n && y < m; x++, y++) {
                if (--hash[grid[x][y]] == 0) right--;
                ans[x][y] = Math.abs(left - right);
                if (++hash1[grid[x][y]] == 1) left++;
            }
        }
        for (int i = 1; i < m; i++) {
            Arrays.fill(hash, 0);
            Arrays.fill(hash1, 0);
            int right = 0;
            for (int x = 0, y = i; x < n && y < m; x++, y++) {
                if (++hash[grid[x][y]] == 1) right++;
            }
            int left = 0;
            for (int x = 0, y = i; x < n && y < m; x++, y++) {
                if (--hash[grid[x][y]] == 0) right--;
                ans[x][y] = Math.abs(left - right);
                if (++hash1[grid[x][y]] == 1) left++;
            }
        }
        return ans;
    }
}