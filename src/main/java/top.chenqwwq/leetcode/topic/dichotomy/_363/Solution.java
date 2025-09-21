package top.chenqwwq.leetcode.topic.dichotomy._363;

/**
 * @author chen
 * @date 2021/5/29
 **/
public class Solution {
	public int maxSumSubmatrix(int[][] matrix, int k) {
		// 找出 matrix 中 和小于 k 的最大区间 x1,y1,x2,y2
		final int rows = matrix.length, cols = matrix[0].length;
		int[][] sum = new int[rows + 1][cols + 1];

		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= cols; j++) {
				sum[i][j] = sum[i - 1][j - 1] + sum[i - 1][j] + sum[i][j - 1] + matrix[i - 1][j - 1];
			}
		}

		// 枚举上下边界
		for (int top = 1; top <= rows; top++) {
			for (int bot = top; bot <= rows; bot++) {
				// 固定左边界
				for (int left = 1; left <= cols; left++) {
					//
				}
			}
		}

		return -1;
	}
}