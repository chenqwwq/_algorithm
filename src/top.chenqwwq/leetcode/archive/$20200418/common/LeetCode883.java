package top.chenqwwq.leetcode.archive.$20200418.common;

/**
 * 883. Projection Area of 3D Shapes
 *
 * @author bingxin.chen
 * @date 2019/6/5 13:08
 */
public class LeetCode883 {
    class Solution {
        public int projectionArea(int[][] grid) {
            int xLen = grid.length, yLen = grid[0].length, ans = 0;
            for (int i = 0; i < xLen; i++) {
                int rowMax = 0, colMax = 0;
                for (int j = 0; j < yLen; j++) {
                    if (grid[i][j] > 0) {
                        ans++;
                    }
                    rowMax = Math.max(rowMax, grid[i][j]);
                    colMax = Math.max(colMax, grid[j][i]);
                }
                ans += rowMax + colMax;
            }
            return ans;
        }
    }
}
