package top.chenqwwq.leetcode.daily._20201030;

/**
 * 463. 岛屿的周长
 * 给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。
 * <p>
 * 网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 * <p>
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
 * <p>
 * <p>
 * <p>
 * 示例 :
 * <p>
 * 输入:
 * [[0,1,0,0],
 * [1,1,1,0],
 * [0,1,0,0],
 * [1,1,0,0]]
 * <p>
 * 输出: 16
 * <p>
 * 解释: 它的周长是下面图片中的 16 个黄色的边：
 *
 * @author chen
 * @date 2020/10/30
 **/
public class Solution {

    // 可以一直往右和下进行探测，一次以2为单位加减
    private int[][] CHANGES = new int[][]{
            {1, 0},
            {0, 1},
            {0, -1},
            {-1, 0}
    };

    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int total = 0, coincide = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                // 陆地块数
                total++;
                // 重合边数
                for (int[] change : CHANGES) {
                    int q = i + change[0], p = j + change[1];
                    if (q >= 0 && q < grid.length && p >= 0 && p < grid[0].length && grid[q][p] == 1) {
                        coincide++;
                    }
                }
            }
        }

        return 4 * total - coincide;
    }
}