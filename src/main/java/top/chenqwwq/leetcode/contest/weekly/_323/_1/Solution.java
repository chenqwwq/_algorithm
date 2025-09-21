package top.chenqwwq.leetcode.contest.weekly._323._1;

import java.util.Arrays;

/**
 * @author chenqwwq
 * @date 2022/12/11
 **/
public class Solution {
    public int deleteGreatestValue(int[][] grid) {
        final int n = grid.length, m = grid[0].length;
        for (int[] ints : grid) Arrays.sort(ints);
        int ans = 0;
        for (int i = 0; i < m; i++) {
            int max = -1;
            for (int[] ints : grid) {
                max = Math.max(max, ints[i]);
            }
            ans += max;
        }
        return ans;
    }
}