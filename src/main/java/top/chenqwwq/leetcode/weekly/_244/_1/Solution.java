package top.chenqwwq.leetcode.weekly._244._1;

/**
 * @author chen
 * @date 2021/6/6
 **/
public class Solution {
	public boolean findRotation(int[][] mat, int[][] target) {
		final int n = mat.length, m = n - 1;
		boolean ok1 = true, ok2 = true, ok3 = true, ok4 = true;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (mat[i][j] != target[i][j]) {
					ok1 = false;
				}
				if (mat[i][j] != target[j][m - i]) {
					ok2 = false;
				}
				if (mat[i][j] != target[m - i][m - j]) {
					ok3 = false;
				}
				if (mat[i][j] != target[m - j][i]) {
					ok4 = false;
				}
			}
		}
		return ok1 || ok2 || ok3 || ok4;
	}
}
