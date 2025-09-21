package top.chenqwwq.leetcode.contest.weekly._299._1;

/**
 * @author chenqwwq
 * @date 2022/6/26
 **/
public class Solution {
    public boolean checkXMatrix(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || i + j == n - 1) {
                    if (grid[i][j] == 0) {
                        return false;
                    }
                } else if (grid[i][j] != 0) {
                    return false;
                }
            }
        }

        return true;
    }
}