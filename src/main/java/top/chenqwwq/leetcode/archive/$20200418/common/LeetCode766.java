package top.chenqwwq.leetcode.archive.$20200418.common;

/**
 * 766.Toeplitz Matrix
 *
 * @author bingxin.chen
 * @date 2019/4/4 10:29
 */
public class LeetCode766 {
    class Solution {
        public boolean isToeplitzMatrix(int[][] matrix) {
            if (matrix == null || matrix.length == 0) {
                return false;
            }
            // 从左下角开始
            for (int i = matrix.length - 1, j = 0; i >= 0 && j < matrix[0].length; ) {
                int m = i, n = j, mode = matrix[m][n];
                while (++m < matrix.length && ++n < matrix[0].length) {
                    if (mode != matrix[m][n]) {
                        return false;
                    }
                }
                if (i > 0) {
                    i--;
                } else {
                    j++;
                }
            }
            return true;
        }
    }
}
