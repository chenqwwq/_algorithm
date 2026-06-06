package top.chenqwwq.leetcode.archive.$20200418.common;

/**
 * 463. Island Perimeter
 *
 * @author bingxin.chen
 * @date 2019/4/4 10:14
 */
public class LeetCode463 {
    class Solution {
        /**
         * 方块总个数 * 4 - 相邻
         */
        public int islandPerimeter(int[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }
            int totalNum = 0, closeNum = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1) {
                        totalNum++;   // 计算贴近的,右下算
                        if (i + 1 < grid.length && grid[i + 1][j] == 1) {
                            closeNum++;
                        }
                        if (j + 1 < grid[0].length && grid[i][j + 1] == 1) {
                            closeNum++;
                        }
                    }
                }
            }
            return totalNum * 4 - closeNum * 2;
        }
    }
}
