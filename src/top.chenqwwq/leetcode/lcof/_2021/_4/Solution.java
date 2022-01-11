package top.chenqwwq.leetcode.lcof._2021._4;

/**
 * @author chen
 * @date 2021/5/29
 **/
public class Solution {
	public boolean findNumberIn2DArray(int[][] matrix, int target) {
		final int rows = matrix.length;
		if (rows == 0) {
			return false;
		}
		final int cols = matrix[0].length;
		int x = rows - 1, y = 0;
		while (x >= 0 && y < cols) {
			if (matrix[x][y] > target) {
				x--;
			} else if (matrix[x][y] < target) {
				y++;
			} else {
				return true;
			}
		}
		return false;
	}
}