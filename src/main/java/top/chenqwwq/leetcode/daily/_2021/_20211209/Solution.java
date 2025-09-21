package top.chenqwwq.leetcode.daily._2021._20211209;

/**
 * @author chenbingxin
 * @date 2021/12/9
 **/
public class Solution {
	private static final char X = 'X', O = 'O', S = ' ';

	public boolean validTicTacToe(String[] board) {
		int xc = 0, oc = 0;

		// X 比 O 多一个或者相同
		// 只有一个三连，如果 X 三连表示 X 比 O 多一个，O 三连则两个相同
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				final char c = board[i].charAt(j);
				if (c == X) {
					xc++;
				}
				if (c == O) {
					oc++;
				}
			}
		}
		if (oc > xc || xc - oc > 1) {
			return false;
		}
		if (valid(board, X) && xc - oc != 1) {
			return false;
		}
		return !valid(board, O) || xc == oc;
	}

	public boolean valid(String[] board, char c) {
		for (int i = 0; i < 3; i++) {
			if (board[i].charAt(0) == c && board[i].charAt(1) == c && board[i].charAt(2) == c) {
				return true;
			}
			if (board[0].charAt(i) == c && board[1].charAt(i) == c && board[2].charAt(i) == c) {
				return true;
			}
		}
		return (board[0].charAt(0) == c && board[1].charAt(1) == c && board[2].charAt(2) == c) || (board[0].charAt(2) == c && board[1].charAt(1) == c && board[2].charAt(0) == c);
	}
}
