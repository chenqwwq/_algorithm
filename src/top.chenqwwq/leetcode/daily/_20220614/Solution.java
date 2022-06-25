package top.chenqwwq.leetcode.daily._20220614;

/**
 * @author chenqwwq
 * @date 2022/6/14
 **/
public class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int[] ans = new int[n * m];
        int[] pre = new int[n + m - 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                pre[i + j]++;
            }
        }
        for (int i = 1; i < n + m - 1; i++) {
            pre[i] += pre[i - 1];
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                final int sum = i + j;
                final int cnt = (sum & 1) == 1 ? Math.abs(j - Math.min(m - 1, sum)) : Math.abs(i - Math.min(n - 1, sum));
                ans[(sum >= 1 ? pre[sum - 1] : 0) + cnt] = mat[i][j];
            }
        }
        return ans;
    }
}