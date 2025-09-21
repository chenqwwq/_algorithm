package top.chenqwwq.leetcode.daily._2023._20230727;

import java.util.Arrays;

/**
 * @author chenqwwq
 * @date 2023/7/27
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