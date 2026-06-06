package top.chenqwwq.leetcode.contest.weekly._337._2;

/**
 * @author chenqwwq
 * @date 2023/3/19
 **/
public class Solution {
    int[] cx = {-2, -2, -1, -1, 1, 1, 2, 2};
    int[] cy = {1, -1, 2, -2, 2, -2, 1, -1};

    public boolean checkValidGrid(int[][] grid) {
        if (grid[0][0] != 0) return false;
        int n = grid.length, m = grid[0].length;
        int cur = 1;
        int x = 0, y = 0;

        while (cur < n * m) {
            boolean flag = false;
            outer:
            for (int xx : cx) {
                for (int yy : cy) {
                    int i = x + xx, j = y + yy;
                    if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != cur) continue;
                    flag = true;
                    x = i;y = j;
                    break outer;
                }
            }
            if(!flag) return false;
            cur++;
        }
        return true;
    }
}