package top.chenqwwq.leetcode.biweek._52._3;

/**
 * @author chen
 * @date 2021/5/15
 **/
public class Solution {
	public char[][] rotateTheBox(char[][] box) {
		// 4 x 3
		int n = box.length, m = box[0].length;
		final char[][] ans = new char[m][n];

		for (int i = n - 1; i >= 0; i--) {
			int j = m - 1, b = j;
			while (j >= 0) {
				if (box[i][j] == '#') {
					if (j != b) {
						box[i][b--] = '#';
						box[i][j] = '.';
					} else {
						b = j - 1;
					}
				} else if (box[i][j] == '*') {
					b = j - 1;
				}
				j--;
			}
		}

		// 倒转
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				ans[j][n - i - 1] = box[i][j];
			}
		}

		return ans;
	}
}