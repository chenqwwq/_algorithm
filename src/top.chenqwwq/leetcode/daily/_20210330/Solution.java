package top.chenqwwq.leetcode.daily._20210330;

/**
 * 74. Search a 2D Matrix
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * <p>
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 *
 * @author chen
 * @date 2021/3/30
 **/
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;

        // 二分
        int left = 0, right = m * n - 1;
        while (left <= right) {
            final int mid = (left + right) >> 1;
            final int curr = matrix[mid / n][mid % n];

            if (curr > target) {
                right = mid - 1;
            } else if (curr < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}