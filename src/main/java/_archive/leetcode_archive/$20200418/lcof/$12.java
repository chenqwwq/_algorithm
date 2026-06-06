package top.chenqwwq.leetcode.archive.$20200418.lcof;

/**
 * 面试题12. 矩阵中的路径
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 * <p>
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 * <p>
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 * 提示：
 * <p>
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/
 *
 * @author chen
 * @date 2020 /3/6 下午3:19
 */
public class $12 {
    /**
     * The type Solution.
     */
    class Solution {
        /**
         * Exist boolean.
         *
         * @param board the board
         * @param word  the word
         * @return the boolean
         */
        public boolean exist(char[][] board, String word) {
            // 回溯
            final char[] chars = word.toCharArray();
            final int iLength = board.length;
            final int jLength = board[0].length;

            boolean[][] isVisit = new boolean[iLength][jLength];

            for (int i = 0; i < iLength; i++) {
                for (int j = 0; j < jLength; j++) {
                    if (isExist(board, chars, i, j, 0, isVisit)) {
                        return true;
                    }
                }
            }
            return false;
        }

        /**
         * 从(i,j)向外扩散寻找
         *
         * @param board   the board
         * @param word    the word
         * @param i       the
         * @param j       the j
         * @param curr    the curr
         * @param isVisit the is visit
         * @return boolean
         */
        public boolean isExist(char[][] board, char[] word, int i, int j, int curr, boolean[][] isVisit) {
            if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || isVisit[i][j] || board[i][j] != word[curr]) {
                return false;
            }
            isVisit[i][j] = true;
            final boolean b = curr == word.length - 1
                    || isExist(board, word, i + 1, j, ++curr, isVisit)
                    || isExist(board, word, i - 1, j, curr, isVisit)
                    || isExist(board, word, i, j - 1, curr, isVisit)
                    || isExist(board, word, i, j + 1, curr, isVisit);

            if (!b) {
                isVisit[i][j] = false;
            }

            return b;
        }
    }
}
