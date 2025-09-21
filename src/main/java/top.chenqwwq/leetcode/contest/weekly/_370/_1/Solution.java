package top.chenqwwq.leetcode.contest.weekly._370._1;

/**
 * @author chenqwwq
 * @date 2023/11/9
 **/
public class Solution {
    public int findChampion(int[][] grid) {
        final int n = grid.length;
        outer:
        for (int i = 0; i < n; i++) {
            for(int j = 0;j < n;j++){
                if(i != j && grid[i][j] != 1) continue outer;
            }
            return i;
        }
        return -1;
    }
}