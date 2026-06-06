package top.chenqwwq.leetcode.topic.dp._931;

/**
 * 931. Minimum Falling Path Sum
 * Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.
 * <p>
 * A falling path starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right.
 * Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
 * Output: 13
 * Explanation: There are two falling paths with a minimum sum underlined below:
 * [[2,1,3],      [[2,1,3],
 * [6,5,4],       [6,5,4],
 * [7,8,9]]       [7,8,9]]
 * Example 2:
 * <p>
 * Input: matrix = [[-19,57],[-40,-5]]
 * Output: -59
 * Explanation: The falling path with a minimum sum is underlined below:
 * [[-19,57],
 * [-40,-5]]
 * Example 3:
 * <p>
 * Input: matrix = [[-48]]
 * Output: -48
 * <p>
 * <p>
 * Constraints:
 * <p>
 * n == matrix.length
 * n == matrix[i].length
 * 1 <= n <= 100
 * -100 <= matrix[i][j] <= 100
 *
 * @author chen
 * @date 2021-05-24
 **/
public class Solution {
	public int minFallingPathSum(int[][] matrix) {
		int n = matrix.length;
		// dp[i][j] 表示从第一排到第i排j列的最小和
		int[][] dp = new int[n][n];
		System.arraycopy(matrix[0], 0, dp[0], 0, n);
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int tmp = Integer.MAX_VALUE / 2;
				for (int c = -1; c <= 1; c++) {
					if (j + c < 0 || j + c >= n) {
						continue;
					}
					tmp = Math.min(tmp, dp[i - 1][j + c] + matrix[i][j]);
				}
				dp[i][j] = tmp;
			}
		}
		return getMin(dp[n - 1]);
	}

	private int getMin(int... nums) {
		int ans = Integer.MAX_VALUE;
		for (int num : nums) {
			if (ans > num) {
				ans = num;
			}
		}
		return ans;
	}
}