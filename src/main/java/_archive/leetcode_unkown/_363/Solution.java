package top.chenqwwq.leetcode.unkown._363;

/**
 * @author chen
 * @date 2021/5/29
 **/
public class Solution {
	public int maxSumSubmatrix(int[][] matrix, int k) {
		final int rows = matrix.length, cols = matrix[0].length;
		int[][] sum = new int[rows + 1][cols + 1];

		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= cols; j++) {
				sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
			}
		}

		int ans = Integer.MIN_VALUE;
		// 穷举
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				for (int q = 0; q <= i; q++) {
					for (int p = 0; p <= j; p++) {
						final int tmp = sumRegion(sum, q, p, i, j);
						if (tmp == k) {
							return k;
						} else if (tmp < k && tmp > ans) {
							ans = tmp;
						}
					}
				}
			}
		}
		return ans;
	}

	public int sumRegion(int[][] sum, int row1, int col1, int row2, int col2) {
		return sum[++row2][++col2] - sum[row2][col1] - sum[row1][col2] + sum[row1][col1];
	}
}