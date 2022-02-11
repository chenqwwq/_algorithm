package top.chenqwwq.leetcode.daily._20200811;

/**
 * 130. 被围绕的区域
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 * <p>
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * <p>
 * 示例:
 * <p>
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 运行你的函数后，矩阵变为：
 * <p>
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 解释:
 * <p>
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 *
 * @author chen
 * @date 2020-08-11
 **/
public class Solution {
    int[][] change = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public void solve(char[][] board) {
        if (board.length == 0) {
            return;
        }
        // 从边界上的0开始进行dfs

        final int x = board.length - 1;
        final int y = board[0].length - 1;
        // 竖直
        for (int i = 0; i < board.length; i++) {
            dfs(board, i, 0);
            dfs(board, i, y);
        }

        // 横向
        for (int i = 1; i < y; i++) {
            dfs(board, 0, i);
            dfs(board, x, i);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                    continue;
                }
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    /**
     * dfs 递归
     */
    public void dfs(char[][] board, int x, int y) {
        if (x >= board.length || x < 0 || y >= board[0].length || y < 0 || board[x][y] != 'O') {
            return;
        }
        board[x][y] = '#';
        for (int[] ints : change) {
            dfs(board, x + ints[0], y + ints[1]);
        }
    }
}