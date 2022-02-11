package top.chenqwwq.leetcode.biweek._54._1;

/**
 * @author chen
 * @date 2021/6/12
 **/
public class Solution {
	public int largestMagicSquare(int[][] grid) {
		final int m = grid.length;
		if (m == 1) {
			return 1;
		}
		final int n = grid[0].length;
//		int[] s1 = new int[m + 1], s2 = new int[n + 1], s3 = new int[m + n], s4 = new int[m + n];
//		for (int i = 0; i < m; i++) {
//			for (int j = 0; j < n; j++) {
//				s1[i + 1] = grid[i][j] + s1[i];
//				s2[j + 1] = grid[i][j] + s2[j];
//			}
//		}

		int max = Math.min(m, n);

		for (int l = max; l > 1; l--) {
			for (int i = 0; i + l <= m; i++) {
				for (int j = 0; j + l <= n; j++) {
					if (check(grid, i, j, l)) {
						return l;
					}
				}
			}
		}
		return 1;
	}

	private boolean check(int[][] grid, int x, int y, int len) {
		int[] s1 = new int[len], s2 = new int[len];
		int s3 = 0, s4 = 0;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				final int num = grid[x + i][y + j];
				s1[i] += num;
				s2[j] += num;
				if (i + j == len - 1) {
					s3 += num;
				}
				if (i == j) {
					s4 += num;
				}
			}
		}

		if (s3 != s4) {
			return false;
		}
		for (int num : s1) {
			if (num != s3) {
				return false;
			}
		}
		for (int num : s2) {
			if (num != s3) {
				return false;
			}
		}
		return true;
	}
}