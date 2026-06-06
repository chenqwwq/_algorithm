package top.chenqwwq.leetcode.archive.$20200418.common;

import java.util.ArrayList;
import java.util.List;

/**
 * 51. N皇后问题
 * <p>
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * 上图为 8 皇后问题的一种解法。
 * <p>
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 * <p>
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * <p>
 * 示例:
 * <p>
 * 输入: 4
 * 输出: [
 * [".Q..",  // 解法 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * <p>
 * ["..Q.",  // 解法 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chen
 * @date 19 -7-20 下午8:05
 */
public class LeetCode51 {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        System.out.println(new LeetCode51().new Solution().solveNQueens(4));
    }

    /**
     * The type Solution.
     */
    class Solution {

        /**
         * The Res.
         */
        List<List<String>> res = new ArrayList<>();

        /**
         * Solve n queens list.
         *
         * @param n the n
         * @return the list
         */
        public List<List<String>> solveNQueens(int n) {
            // N皇后问题是回溯的经典题目了

            // 构建n * n的棋盘
            chooseBoard(0, new int[n][n], n);

            return res;
        }

        /**
         * 递归选择皇后位置
         *
         * @param curr       the 当前行
         * @param chessboard the chessboard
         * @param n          the 最大航
         * @return boolean
         */
        private void chooseBoard(int curr, int[][] chessboard, int n) {
            if (curr == n) {
                addRes(chessboard);
                return;
            }

            for (int i = 0; i < n; i++) {
                // 内存遍历选择皇后的具体位置
                if (checkProper(chessboard, curr, i)) {
                    chessboard[curr][i] = 1;
                    chooseBoard(curr + 1, chessboard, n);
                    chessboard[curr][i] = 0;
                }
            }
        }

        private void addRes(int[][] chessboard) {
            List<String> list = new ArrayList<>();

            for (int[] ints : chessboard) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int j = 0; j < chessboard.length; j++) {
                    stringBuilder.append(ints[j] == 1 ? 'Q' : '.');
                }
                list.add(stringBuilder.toString());
            }

            res.add(list);
        }

        /**
         * 判断正确性
         *
         * @param chessboard 棋盘
         * @param i          当前的横坐标
         * @param j          当前的纵坐标
         * @return
         */
        private boolean checkProper(int[][] chessboard, int i, int j) {
            int length = chessboard.length;

            // t表示行
            for (int t = 0; t < length; t++) {
                if (t == i) {
                    continue;
                }
                // 纵向的检查
                if (chessboard[t][j] == 1) {
                    return false;
                }

                // 正斜线的检查
                int i1 = t + j - i;
                if (i1 >= 0 && i1 < length && chessboard[t][i1] == 1) {
                    return false;
                }

                int i2 = i + j - t;
                if (i2 >= 0 && i2 < length && chessboard[t][i2] == 1) {
                    return false;
                }
            }
            return true;
        }
    }
}
