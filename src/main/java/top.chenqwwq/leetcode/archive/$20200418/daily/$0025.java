package top.chenqwwq.leetcode.archive.$20200418.daily;

/**
 * 892. 三维形体的表面积
 * 在 N * N 的网格上，我们放置一些 1 * 1 * 1  的立方体。
 * <p>
 * 每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
 * <p>
 * 请你返回最终形体的表面积。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[[2]]
 * 输出：10
 * 示例 2：
 * <p>
 * 输入：[[1,2],[3,4]]
 * 输出：34
 * 示例 3：
 * <p>
 * 输入：[[1,0],[0,2]]
 * 输出：16
 * 示例 4：
 * <p>
 * 输入：[[1,1,1],[1,0,1],[1,1,1]]
 * 输出：32
 * 示例 5：
 * <p>
 * 输入：[[2,2,2],[2,1,2],[2,2,2]]
 * 输出：46
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= N <= 50
 * 0 <= grid[i][j] <= 50
 *
 * @author chen
 * @date 2020/3/25 上午10:19
 */
public class $0025 {
    public int surfaceArea(int[][] grid) {
        int N = grid.length, cubes = 0, faces = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                cubes += grid[i][j];
                // 上下重叠的面积
                if (grid[i][j] > 1) {
                    faces += grid[i][j] - 1;
                }
                // 横向重叠
                if (i > 0) {
                    faces += Math.min(grid[i - 1][j], grid[i][j]);
                }
                // 纵向重叠
                if (j > 0) {
                    faces += Math.min(grid[i][j - 1], grid[i][j]);
                }
            }
        }
        return 6 * cubes - 2 * faces;
    }

}
