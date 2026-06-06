package top.chenqwwq.leetcode.daily._2026._20260317;

import java.util.Arrays;

/**
 * @author chenqwwq
 * @date 2026/3/17
 **/
public class Solution {
    public int largestSubmatrix(int[][] matrix) {
        final int n = matrix.length, m = matrix[0].length;

        int ans = 0;
        final int[] sum = new int[m];
        int[] ss = new int[m];
        for (int[] line : matrix) {
            for (int i = 0; i < m; i++) {
                if (line[i] == 0) sum[i] = 0;
                else sum[i]++;
            }
            System.arraycopy(sum, 0, ss, 0, m);
            Arrays.sort(ss);
            for (int i = 0; i < m; i++) {
                ans = Math.max(ans, ss[i] * (m - i));
            }
        }

        return ans;
    }
}