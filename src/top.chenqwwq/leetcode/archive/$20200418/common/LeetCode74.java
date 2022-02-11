package top.chenqwwq.leetcode.archive.$20200418.common;

/**
 * 搜索二维矩阵
 * 二分查找变种,从每行的末尾开始对比
 *
 * @author chen
 * @date 19-4-14
 */
public class LeetCode74 {
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return false;
            }
            int i = matrix.length, j = matrix[0].length;
            if (target < matrix[0][0] || target > matrix[i - 1][j - 1]) {
                return false;
            }

            for (int i1 = 0; i1 < i; i1++) {
                // 确定目标
                if (matrix[i1][j - 1] == target) {
                    return true;
                }
                if (matrix[i1][j - 1] > target) {
                    for (int j1 = j; j1 > 0; j1--) {
                        if (matrix[i1][j1 - 1] == target) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }
}
