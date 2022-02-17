package top.chenqwwq.leetcode.daily._20220212;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author chen
 * @date 2022/2/12
 **/
public class Solution {
    int[] cx = {0, 0, -1, 1}, cy = {1, -1, 0, 0};

    public int numEnclaves(int[][] grid) {
        final int n = grid.length, m = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            if (grid[0][i] == 1) {
                queue.add(new int[]{0, i});
                grid[0][i] = 0;
            }
            if (grid[n - 1][i] == 1) {
                queue.add(new int[]{n - 1, i});
                grid[n - 1][i] = 0;
            }
        }
        for (int i = 1; i < n - 1; i++) {
            if (grid[i][m - 1] == 1) {
                queue.add(new int[]{i, m - 1});
                grid[i][m - 1] = 0;
            }
            if (grid[i][0] == 1) {
                queue.add(new int[]{i, 0});
                grid[i][0] = 0;
            }
        }

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            final int x = curr[0], y = curr[1];
            for (int i = 0; i < 4; i++) {
                int a = x + cx[i], b = y + cy[i];
                if (a < 0 || b < 0 || a >= n || b >= m || grid[a][b] == 0) {
                    continue;
                }
                queue.add(new int[]{a, b});
                grid[a][b] = 0;
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans += grid[i][j];
            }
        }
        return ans;
    }
}
