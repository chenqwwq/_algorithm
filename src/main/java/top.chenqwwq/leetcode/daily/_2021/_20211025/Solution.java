package top.chenqwwq.leetcode.daily._2021._20211025;

/**
 * @author chen
 * @date 2021/10/25
 **/
public class Solution {
	public boolean searchMatrix(int[][] matrix, int target) {
		int n = matrix.length, m = matrix[0].length;
		int i = n - 1, j = 0;
		while (i >= 0 && j < m) {
			if (matrix[i][j] == target) {
				return true;
			} else if (matrix[i][j] > target) {
				i--;
			} else {
				j++;
			}
		}
		return false;
	}
}