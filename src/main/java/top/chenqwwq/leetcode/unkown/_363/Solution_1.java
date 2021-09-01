package top.chenqwwq.leetcode.unkown._363;

/**
 * @author chen
 * @date 2021/5/29
 **/
public class Solution_1 {
	public int maxSumSubmatrix(int[][] matrix, int k) {
		int rows = matrix.length, cols = matrix[0].length;

		// 固定左右边界
		int ans = Integer.MIN_VALUE;
		for (int left = 0; left < cols; left++) {
			int[] rowSum = new int[rows];
			for (int right = left; right < cols; right++) {
				for (int top = 0; top < rows; top++) {
					rowSum[top] += matrix[top][right];
				}
				// 从 rowSum 中找到小于 k 的最大子序列
				final int lessKMax = getLessKMax(rowSum, k);
				if (lessKMax == k) {
					return k;
				}
				ans = Math.max(lessKMax, ans);
			}
		}
		return ans;
	}

	/**
	 * 在一个无序数组中找到小于k的最小
	 */
	public int getLessKMax(int[] rowSum, int k) {
		final int len = rowSum.length;
		int ans = Integer.MIN_VALUE;
		for (int i = 0; i < len; i++) {
			int sum = 0;
			for (int j = i; j < len; j++) {
				sum += rowSum[j];
				if (sum == k) {
					return k;
				}
				if (sum < k) {
					ans = Math.max(sum, ans);
				}
			}
		}
		return ans;
	}
}
