package top.chenqwwq.leetcode.daily._2026._20260504;

/**
 * @author chenqwwq
 * @date 2026/5/4
 **/
public class Solution {
    public void rotate(int[][] matrix) {
        final int n = matrix.length;
        for (int i = 0; i < n >> 1; i++) { // 一半
            for (int j = 0; j < (n + 1) >> 1; j++) { // 一半
                int t = matrix[i][j];       // 0,0
                matrix[i][j] = matrix[n - 1 - j][i];    // 0,0 = 2,0
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];    // 2,0 = 2,2
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];    // 2,2 = 0,2
                matrix[j][n - 1 - i] = t;
            }
        }
    }
}