package top.chenqwwq.leetcode.topic.dp._304;

/**
 * @author chen
 * @date 2021/5/29
 **/
public class NumMatrix {

	int[][] sum;

	public NumMatrix(int[][] matrix) {
		final int cols = matrix[0].length, rows = matrix.length;
		sum = new int[rows + 1][cols + 1];

		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= cols; j++) {
				sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
			}
		}
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		return sum[row2+1][col2+1] - sum[row2+1][col1] - sum[row1][col2+1] + sum[row1][col1];
	}
}