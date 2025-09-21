package top.chenqwwq.leetcode.archive.$20200418.daily;

/**
 * 695. 岛屿的最大面积
 * 给定一个包含了一些 0 和 1的非空二维数组 grid , 一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地) 构成的组合。你可以假设二维矩阵的四个边缘都被水包围着。
 * <p>
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)
 * <p>
 * 示例 1:
 * <p>
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,1,1,0,1,0,0,0,0,0,0,0,0],
 * [0,1,0,0,1,1,0,0,1,0,1,0,0],
 * [0,1,0,0,1,1,0,0,1,1,1,0,0],
 * [0,0,0,0,0,0,0,0,0,0,1,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * 对于上面这个给定矩阵应返回 6。注意答案不应该是11，因为岛屿只能包含水平或垂直的四个方向的‘1’。
 * <p>
 * 示例 2:
 * <p>
 * [[0,0,0,0,0,0,0,0]]
 * 对于上面这个给定的矩阵, 返回 0。
 * <p>
 * 注意: 给定的矩阵grid 的长度和宽度都不超过 50。
 *
 * @author chen
 * @date 2020/3/15 上午9:30
 */
public class $0015 {
    class Solution {
        private static final int FLAG = Integer.MAX_VALUE;

        public int maxAreaOfIsland(int[][] grid) {
            if (grid == null) {
                return 0;
            }
            int res = 0;

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    // 已经访问过的就跳过
                    if (grid[i][j] == FLAG) {
                        continue;
                    }
                    res = Math.max(res, dfs(grid, i, j));
                }
            }
            return res;
        }

        private int dfs(int[][] grid, int i, int j) {
            if (i >= grid.length || i < 0 || j >= grid[0].length || j < 0 || grid[i][j] == Integer.MAX_VALUE || grid[i][j] == 0) {
                return 0;
            }

            // 剩下的只有等于1的情况
            grid[i][j] = FLAG;
            return 1 + dfs(grid, i + 1, j) + dfs(grid, i - 1, j) + dfs(grid, i, j - 1) + dfs(grid, i, j + 1);
        }
    }
}
