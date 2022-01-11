package top.chenqwwq.leetcode.archive.$20200418.by_topics.bfs_dfs;

/**
 * 419. 甲板上的战舰
 * <p>
 * 给定一个二维的甲板， 请计算其中有多少艘战舰。 战舰用 'X'表示，空位用 '.'表示。 你需要遵守以下规则：
 * <p>
 * 给你一个有效的甲板，仅由战舰或者空位组成。
 * 战舰只能水平或者垂直放置。换句话说,战舰只能由 1xN (1 行, N 列)组成，或者 Nx1 (N 行, 1 列)组成，其中N可以是任意大小。
 * 两艘战舰之间至少有一个水平或垂直的空位分隔 - 即没有相邻的战舰。
 * 示例 :
 * <p>
 * X..X
 * ...X
 * ...X
 * 在上面的甲板中有2艘战舰。
 * <p>
 * 无效样例 :
 * <p>
 * ...X
 * XXXX
 * ...X
 * 你不会收到这样的无效甲板 - 因为战舰之间至少会有一个空位将它们分开。
 *
 * @author chen
 * @date 2019/12/9 下午10:43
 */
public class $419_BattleshipsInABoard {
    class Solution {

        private static final char MARK = 'X';

        private static final char SYMBOL = '#';

        private static final char SIGN = '.';

        public int countBattleships(char[][] board) {
            int res = 0;
            // 从左上角开始遍历
            // 从左往右 从上往下
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    // 遇到`#,.`直接跳出
                    if (board[i][j] == SYMBOL || board[i][j] == SIGN) {
                        continue;
                    }

                    // 遇到X就BFS标记所有的路径
                    if (MARK == board[i][j]) {
                        bfs(board, i, j);
                        res++;
                    }
                }
            }

            return res;
        }

        /**
         * 从i,j节点开始左往右,上往下遍历
         */
        public void bfs(char[][] board, int x, int y) {
            if (x >= board.length || y >= board[0].length) {
                return;
            }
            if (MARK == board[x][y]) {
                board[x][y] = SYMBOL;
                bfs(board, x + 1, y);
                bfs(board, x, y + 1);
            }
        }
    }
}
