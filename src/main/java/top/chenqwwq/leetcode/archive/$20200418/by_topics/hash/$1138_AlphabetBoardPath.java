package top.chenqwwq.leetcode.archive.$20200418.by_topics.hash;

/**
 * 1138. 字母板上的路径
 * <p>
 * 题目描述
 * 评论 (18)
 * 题解(22)New
 * 提交记录
 * 我们从一块字母板上的位置 (0, 0) 出发，该坐标对应的字符为 board[0][0]。
 * <p>
 * 在本题里，字母板为board = ["abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"].
 * <p>
 * 我们可以按下面的指令规则行动：
 * <p>
 * 如果方格存在，'U' 意味着将我们的位置上移一行；
 * 如果方格存在，'D' 意味着将我们的位置下移一行；
 * 如果方格存在，'L' 意味着将我们的位置左移一列；
 * 如果方格存在，'R' 意味着将我们的位置右移一列；
 * '!' 会把在我们当前位置 (r, c) 的字符 board[r][c] 添加到答案中。
 * 返回指令序列，用最小的行动次数让答案和目标 target 相同。你可以返回任何达成目标的路径。
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = "leet"
 * 输出："DDR!UURRR!!DDD!"
 * 示例 2：
 * <p>
 * 输入：target = "code"
 * 输出："RR!DDRR!UUL!R!"
 * <p>
 * 提示：
 * <p>
 * 1 <= target.length <= 100
 * target 仅含有小写英文字母。
 *
 * @author bingxin.chen
 * @date 2019/11/29 11:33
 */
public class $1138_AlphabetBoardPath {

    class Solution {

        public String alphabetBoardPath(String target) {

            int currX = 0, currY = 0;
            StringBuilder res = new StringBuilder();
            for (char ch : target.toCharArray()) {
                int tar = ch - 'a';
                int tarX = tar % 5;
                int tarY = tar / 5;

                // 需要考虑z的独特位置
                if (currY == 5) {
                    if (tarY > currY) {
                        while (currY++ < tarY) {
                            res.append("D");
                        }
                    } else if (tarY < currY) {
                        while (currY-- > tarY) {
                            res.append("U");
                        }
                    }

                    if (tarX > currX) {
                        while (currX++ < tarX) {
                            res.append("R");
                        }
                    } else if (tarX < currX) {
                        while (currX-- > tarX) {
                            res.append("L");
                        }
                    }
                } else {
                    if (tarX > currX) {
                        while (currX++ < tarX) {
                            res.append("R");
                        }
                    } else if (tarX < currX) {
                        while (currX-- > tarX) {
                            res.append("L");
                        }
                    }

                    if (tarY > currY) {
                        while (currY++ < tarY) {
                            res.append("D");
                        }
                    } else if (tarY < currY) {
                        while (currY-- > tarY) {
                            res.append("U");
                        }
                    }
                }


                res.append("!");
                currX = tarX;
                currY = tarY;
            }
            return res.toString();
        }
    }
}
