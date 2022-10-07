package top.chenqwwq.leetcode.daily._20220930;

/**
 * @author chenqwwq
 * @date 2022/10/1
 **/
public class Solution {
    public void setZeroes(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        boolean[] rows = new boolean[n], cols = new boolean[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) rows[i] = cols[j] = true;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = mat[i][j] == 0 ? 0 : (rows[i] || cols[j] ? 0 : mat[i][j]);
            }
        }
    }
}