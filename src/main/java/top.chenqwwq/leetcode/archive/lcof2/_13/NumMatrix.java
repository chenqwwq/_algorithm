package top.chenqwwq.leetcode.archive.lcof2._13;

/**
 * @author chenbingxin
 * @date 2021/12/10
 **/
public class NumMatrix {
	// 二维前缀和

	int[][] raws;
	int[][] sums;

	public NumMatrix(int[][] matrix) {
		this.raws = matrix;
		final int n = raws.length, m = raws[0].length;
		this.sums = new int[n + 1][m + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				sums[i][j] = sums[i][j-1] + sums[i-1][j] + matrix[i-1][j-1] - sums[i-1][j-1];
			}
		}
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		return sums[row2+1][col2+1] - sums[row2+1][col1] - sums[row1][col2+1] + sums[row1][col1];
	}
}