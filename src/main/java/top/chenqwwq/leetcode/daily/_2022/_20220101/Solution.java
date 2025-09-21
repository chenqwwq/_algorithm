package top.chenqwwq.leetcode.daily._2022._20220101;

/**
 * @author chenbingxin
 * @date 2022/1/1
 **/
public class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        final int len = original.length;
        if (len != n * m) {
            return new int[][]{};
        }

        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            System.arraycopy(original, i * n, ans[i], 0, n);
        }
        return ans;
    }
}