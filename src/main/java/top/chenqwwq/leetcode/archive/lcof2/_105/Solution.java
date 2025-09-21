package top.chenqwwq.leetcode.archive.lcof2._105;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author chenbingxin
 * @date 2022/1/3
 **/
public class Solution {
    int[] cx = new int[]{1, -1, 0, 0};
    int[] cy = new int[]{0, 0, 1, -1};

    public int maxAreaOfIsland(int[][] grid) {
        final int n = grid.length, m = grid[0].length;
        boolean[][] vis = new boolean[n][m];

        Queue<int[]> queue = new LinkedList<>();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] || grid[i][j] == 0) {
                    continue;
                }
                vis[i][j] = true;
                queue.add(new int[]{i, j});
                int size = 1;
                while (!queue.isEmpty()) {
                    final int[] pos = queue.poll();
                    for (int k = 0; k < 4; k++) {
                        final int x = cx[k] + pos[0], y = cy[k] + pos[1];
                        if(x  < 0 || y < 0 || x >= n || y >= m){
                            continue;
                        }
                        if (grid[x][y] == 1 && !vis[x][y]) {
                            vis[x][y] = true;
                            queue.offer(new int[]{x, y});
                            size++;
                        }
                    }
                }
                ans = Math.max(ans, size);
            }
        }
        return ans;
    }
}