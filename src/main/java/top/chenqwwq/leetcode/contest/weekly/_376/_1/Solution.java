package top.chenqwwq.leetcode.contest.weekly._376._1;

/**
 * @author chenqwwq
 * @date 2023/12/17
 **/
public class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        final int n = grid.length;
        boolean[] vis = new boolean[n * n + 1];
        int a = -1;
        for (int[] ints : grid) {
            for (int j = 0; j < n; j++) {
                if (vis[ints[j]]) a = ints[j];
                vis[ints[j]] = true;
            }
        }
        for (int i = 1; i <= n * n;i++){
            if(!vis[i]) return new int[]{a,i};
        }
        return new int[]{};
    }
}