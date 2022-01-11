package top.chenqwwq.leetcode.archive.$20200418.by_topics.array;

/**
 * 59. 螺旋矩阵 II
 * <p>
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 *
 * @author bingxin.chen
 * @date 2019/12/16 16:36
 */
public class $59_SpiralMatrixII {

    class Solution {
        public int[][] generateMatrix(int n) {
            int[][] matrix = new int[n][n];

            // 一圈一圈向里面缩进
            final int maxLevel = n / 2 + 1;
            int curr = 0, x = 0, y = 0, level = 0;

            while (level < maxLevel) {

                while (y < n - level) {
                    matrix[x][y++] = ++curr;
                }

                y--;

                while (++x < n - level) {
                    matrix[x][y] = ++curr;
                }

                x--;

                while (--y >= level) {
                    matrix[x][y] = ++curr;
                }

                y++;

                while (--x > level) {
                    matrix[x][y] = ++curr;
                }

                x = ++level;
                y = level;
            }

            return matrix;
        }
    }
}
