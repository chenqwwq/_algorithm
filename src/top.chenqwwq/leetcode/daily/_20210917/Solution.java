package top.chenqwwq.leetcode.daily._20210917;

/**
 * @author chen
 * @date 2021/9/17
 **/
public class Solution {
	boolean[][][] exists = new boolean[3][9][9];

	public boolean isValidSudoku(char[][] board) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.') {
					continue;
				}
				final int num = board[i][j] - '0' - 1, idx = i / 3 * 3 + j / 3;
				if (exists[0][i][num] || exists[1][j][num] || exists[2][idx][num]) {
					return false;
				}
				exists[0][i][num] = true;
				exists[1][j][num] = true;
				exists[2][idx][num] = true;
			}
		}

		return true;
	}
}