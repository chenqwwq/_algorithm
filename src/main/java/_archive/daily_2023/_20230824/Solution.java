package top.chenqwwq.leetcode.daily._2023._20230824;

/**
 * @author chenqwwq
 * @date 2023/8/24
 **/
public class Solution {

    int[] cx = new int[]{-1, 0, 1, 0};
    int[] cy = new int[]{0, 1, 0, -1};

    public int countServers(int[][] grid) {
        final int n = grid.length,m = grid[0].length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) continue;
                for (int k = 0; k < 4; k++) {
                    int x = i + cx[k], y = j + cy[k];
                    if (x < 0 || y < 0 || x >= n || y >= n || grid[x][y] == 0) continue;
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}
