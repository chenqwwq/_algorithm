package top.chenqwwq.leetcode.topic.backtrack._08_12;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 08.12. Eight Queens LCCI
 * Write an algorithm to print all ways of arranging n queens on an n x n chess board so that none of them share the same row, column, or diagonal. In this case, "diagonal" means all diagonals, not just the two that bisect the board.
 * Notes: This problem is a generalization of the original one in the book.
 * Example:
 * Input: 4
 * Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * Explanation: 4 queens has following two solutions
 * [
 * [".Q..",  // solution 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * <p>
 * ["..Q.",  // solution 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 *
 * @author chen
 * @date 2021-03-31
 **/

public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] chess = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chess[i][j] = '.';
            }
        }
        backtrack(0, chess, ans, n);
        return ans;
    }

    private void backtrack(int level, char[][] chess, List<List<String>> ans, int n) {
        if (level == n) {
            List<String> res = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                res.add(new String(chess[i]));
            }
            ans.add(res);
            return;
        }

        for (int i = 0; i < n; i++) {
            chess[level][i] = 'Q';
            if (check(chess)) {
                backtrack(level + 1, chess, ans, n);
            }
            chess[level][i] = '.';
        }
    }

    private boolean check(char[][] chess) {
        // 检查
        final int n = chess.length;
        boolean[] row = new boolean[n], column = new boolean[n];
        final int m = 2 * n - 1;
        boolean[] diagonal = new boolean[m], antiDiagonal = new boolean[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (chess[i][j] == 'Q') {
                    if (row[i] || column[j] || diagonal[i + j] || antiDiagonal[i - j + n - 1]) {
                        return false;
                    }
                    row[i] = column[j] = diagonal[i + j] = antiDiagonal[i - j + n - 1] = true;
                }
            }
        }
        return true;
    }
}