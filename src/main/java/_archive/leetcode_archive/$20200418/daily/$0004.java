package top.chenqwwq.leetcode.archive.$20200418.daily;

import java.util.Stack;

/**
 * 994. 腐烂的橘子
 * 在给定的网格中，每个单元格可以有以下三个值之一：
 * <p>
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
 * <p>
 * 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[[2,1,1],[1,1,0],[0,1,1]]
 * 输出：4
 * 示例 2：
 * <p>
 * 输入：[[2,1,1],[0,1,1],[1,0,1]]
 * 输出：-1
 * 解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
 * 示例 3：
 * <p>
 * 输入：[[0,2]]
 * 输出：0
 * 解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
 * <p>
 * 提示：
 * <p>
 * 1 <= grid.length <= 10
 * 1 <= grid[0].length <= 10
 * grid[i][j] 仅为 0、1 或 2
 *
 * @author chen
 * @date 2020/3/6 下午3:51
 */
public class $0004 {
    class Solution {
        int[] changeI = {-1, 0, 1, 0};
        int[] changeJ = {0, 1, 0, -1};

        public int orangesRotting(int[][] grid) {

            if (grid == null || grid.length == 0) {
                return -1;
            }

            // 考虑过dfs，好像是不好处理
            // 还是用dfs
            Stack<Node>[] nodes = new Stack[10];
            int epoch = 0;

            // 将所有的腐烂橘子入队列
            nodes[0] = new Stack<>();
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 2) {
                        nodes[epoch].push(new Node(i, j));
                    }
                }
            }

            boolean haveBad = false;
            for (; epoch < 10; epoch++) {
                if (epoch < 9) {
                    nodes[epoch + 1] = new Stack<>();
                }
                while (!nodes[epoch].isEmpty()) {
                    haveBad = true;
                    final Node pop = nodes[epoch].pop();
                    for (int a = 0; a < 4; a++) {
                        final int i1 = pop.i + changeI[a];
                        final int j1 = pop.j + changeJ[a];
                        if (i1 < 0 || i1 >= grid.length || j1 < 0 || j1 >= grid[0].length) {
                            continue;
                        }
                        if (grid[i1][j1] == 1) {
                            grid[i1][j1] = 2;
                            nodes[epoch + 1].push(new Node(i1, j1));
                        }
                    }
                }
                if (!haveBad) {
                    break;
                } else {
                    haveBad = false;
                }
            }

            for (int[] ints : grid) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (ints[j] == 1) {
                        return -1;
                    }
                }
            }

            return epoch == 0 ? epoch : epoch - 1;
        }

        class Node {
            int i;
            int j;

            public Node(int i, int j) {
                this.i = i;
                this.j = j;
            }
        }
    }
}
