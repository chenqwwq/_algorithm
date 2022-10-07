package top.chenqwwq.leetcode.contest.weekly._295._4;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author chenqwwq
 * @date 2022/5/29
 **/
public class Solution {
    int[] cx = new int[]{0, 0, 1, -1};
    int[] cy = new int[]{1, -1, 0, 0};

    public int minimumObstacles(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        queue.add(new int[]{n - 1, m - 1, 0});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0], y = poll[1], c = poll[2];
            for (int i = 0; i < 4; i++) {
                int a = x + cx[i], b = y + cy[i];
                if (a < 0 || b < 0 || a >= n || b >= m || vis[a][b]) {
                    continue;
                }
                if (a == 0 && b == 0) {
                    return c + grid[a][b];
                }
                queue.add(new int[]{a, b, c + grid[a][b]});
                vis[a][b] = true;
            }
        }
        return -1;
    }
}