package top.chenqwwq.leetcode.contest.biweek._102._1;

/**
 * @author chenqwwq
 * @date 2023/4/16
 **/
public class Solution {
    public int[] findColumnWidth(int[][] grid) {
        final int n = grid.length, m = grid[0].length;
        int[] ans = new int[m];
        for (int[] ints : grid) {
            for (int j = 0; j < m; j++) {
                ans[j] = Math.max(ans[j], String.valueOf(ints[j]).length());
            }
        }
        return ans;
    }
}