package top.chenqwwq.leetcode.archive.$20200418.lcof;

/**
 * 面试题04. 二维数组中的查找
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * <p>
 * 示例:
 * <p>
 * 现有矩阵 matrix 如下：
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * <p>
 * 给定 target = 20，返回 false。
 * <p>
 * 限制：
 * 0 <= n <= 1000
 * 0 <= m <= 1000
 * <p>
 * 注意：本题与主站 240 题相同：https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 *
 * @author chen
 * @date 2020/3/6 下午3:09
 */
public class $04 {
    class Solution {
        public boolean findNumberIn2DArray(int[][] matrix, int target) {
            // 从左下角或者右上角开始查找

            // 判断范围
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return false;
            }
            int a = matrix.length, b = matrix[0].length;
            if (target < matrix[0][0] || target > matrix[a - 1][b - 1]) {
                return false;
            }

            // 右上角开始
            for (int i = 0, j = b - 1; i < a && j >= 0; ) {
                if (matrix[i][j] > target) {
                    j--;
                } else if (matrix[i][j] < target) {
                    i++;
                } else {
                    return true;
                }
            }

            return false;
        }
    }
}
