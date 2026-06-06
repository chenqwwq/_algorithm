package top.chenqwwq.leetcode.contest.weekly._373._1;

/**
 * @author chenqwwq
 * @date 2023/11/26
 **/
public class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        final int n = mat.length, m = mat[0].length;
        k %= m;
        for (int i = 0; i < n; i++) {
            if ((i & 1) == 0) {
                for (int a = 0, b = (a + k) % m, x = 0; x < k; x++, a = (a - x + m) % m, b = (b - x + m) % m) {
                    if (mat[i][a] != mat[i][b]) return false;
                }
            } else {
                for (int a = 0, b = (a + k) % m, x = 0; x < k; x++,a = (a + x) % m, b = (b + x) % m) {
                    if (mat[i][a] != mat[i][b]) return false;
                }
            }
        }
        return true;
    }
}