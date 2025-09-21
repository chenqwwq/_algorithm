package top.chenqwwq.leetcode.contest.biweek._58._2;

/**
 * @author chen
 * @date 2021/8/7
 **/
public class Solution {

	public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
		return isOk(board, rMove, cMove, color);
	}

	int[] cx = {1, 0, 0, -1, 1, 1, -1, -1};
	int[] cy = {0, 1, -1, 0, 1, -1, 1, -1};

	public boolean isOk(char[][] board, int x, int y, char color) {
		for (int i = 0; i < 8; i++) {
			int q = x + cx[i], p = y + cy[i], cnt = 1;
			while (q >= 0 && q < board.length && p >= 0 && p < board[0].length) {
				cnt++;
				if (board[q][p] == '.') {
					break;
				} else if (board[q][p] == color) {
					if (cnt > 2) {
						return true;
					}
					break;
				}
				q += cx[i];
				p += cy[i];
			}
		}
		return false;
	}
}