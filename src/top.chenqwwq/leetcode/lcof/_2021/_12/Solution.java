package top.chenqwwq.leetcode.lcof._2021._12;

/**
 * @author chen
 * @date 2021/5/29
 **/
public class Solution {

	int[] X = {0, 0, 1, -1};
	int[] Y = {1, -1, 0, 0};

	public boolean exist(char[][] board, String word) {
		final int rows = board.length, cols = board[0].length;
		final boolean[][] exist = new boolean[rows][cols];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (dfs(board, word, 0, i, j, exist)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean dfs(char[][] board, String word, int idx, int x, int y, boolean[][] exist) {
		if (idx == word.length()) {
			return true;
		}
		final int rows = board.length, cols = board[0].length;
		if (x < 0 || y < 0 || x >= rows || y >= cols || exist[x][y] || board[x][y] != word.charAt(idx)) {
			return false;
		}

		exist[x][y] = true;
		for (int i = 0; i < 4; i++) {
			if (dfs(board, word, idx + 1, x + X[i], y + Y[i], exist)) {
				return true;
			}
		}
		exist[x][y] = false;

		return false;
	}
}