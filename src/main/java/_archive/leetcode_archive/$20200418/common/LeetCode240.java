package top.chenqwwq.leetcode.archive.$20200418.common;

/**
 * 240. 搜索二维矩阵 II
 *
 * @author chen
 * @date 19-4-14
 */
public class LeetCode240 {
    public static void main(String[] args) {
        new LeetCode240().new Solution().searchMatrix(new int[][]{{-1}, {-1}}, 0);
    }

    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            // 从左下角开始遍历
            int i, j;
            if (matrix == null || (i = matrix.length) == 0 || (j = matrix[0].length) == 0) {
                return false;
            }

            for (int p = 0, q = i - 1; p < j && q >= 0; ) {
                if (matrix[q][p] > target) {
                    q--;
                } else if (matrix[q][p] < target) {
                    p++;
                } else if (matrix[q][p] == target) {
                    return true;
                }
            }
            return false;
        }
    }
}
