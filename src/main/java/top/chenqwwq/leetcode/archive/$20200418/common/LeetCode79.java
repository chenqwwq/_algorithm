package top.chenqwwq.leetcode.archive.$20200418.common;

/**
 * 79. Word Search
 *
 * @author chen
 * @date 19-5-19
 */
public class LeetCode79 {
    public static void main(String[] args) {
//        [["A","B","C","E"],["S","F","E","S"],["A","D","E","E"]]
//        "ABCESEEEFS"
        System.out.println(new LeetCode79().new Solution().exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCESEEEFS"));
    }

    class Solution {
        int iLength;
        int jLength;

        public boolean exist(char[][] board, String word) {
            if (board == null || board.length == 0 || word.length() == 0) {
                return false;
            }

            // 记录数组大小
            iLength = board.length;
            jLength = board[0].length;

            // 获取第一个字符
            final char key = word.charAt(0);

            for (int i = 0; i < iLength; i++) {
                for (int j = 0; j < jLength; j++) {
                    if (board[i][j] == key && search(board, word, 0, i, j, new boolean[iLength][jLength])) {
                        return true;
                    }
                }
            }
            return false;
        }

        /**
         * 从i,j坐标开始回溯遍历
         *
         * @param board 完整的二维数组
         * @param word  目标单词
         * @param index 单词字母的位置
         * @param i     横坐标
         * @param j     纵坐标
         * @param exist 是否访问过
         * @return true -> 搜索的单词存在 false —> 不存在
         */
        private boolean search(char[][] board, String word, int index, int i, int j, boolean[][] exist) {

            // 排除意外情况
            if (i < 0 || i >= iLength || j < 0 || j >= jLength || exist[i][j] || board[i][j] != word.charAt(index)) {
                return false;
            }

            // 路径正确时的处理
            exist[i][j] = true;
            if (++index == word.length()) {
                return true;
            }

            final boolean b = search(board, word, index, i + 1, j, exist)
                    || search(board, word, index, i, j + 1, exist)
                    || search(board, word, index, i - 1, j, exist)
                    || search(board, word, index, i, j - 1, exist);
            // 返回之前将访问状态置为false
            // 方便别的路径遍历
            exist[i][j] = false;
            return b;
        }
    }
}
