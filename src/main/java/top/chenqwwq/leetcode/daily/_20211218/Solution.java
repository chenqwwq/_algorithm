package top.chenqwwq.leetcode.daily._20211218;

/**
 * @author chenbingxin
 * @date 2021/12/18
 **/
public class Solution {
	final char x = 'X';
	public int countBattleships(char[][] board) {
		final int n = board.length, m = board[0].length;
		int ans = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(board[i][j] == '.'){
					continue;
				}
				ans ++;
				int a = i,b = j;
				while (++a < n && board[a][j] == x){
					board[a][j] = '.';
				}
				while (++b < m && board[i][b] == x){
					board[i][b] = '.';
				}
				board[i][j] = '.';
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		new Solution().countBattleships(new char[][]{{'X','X','X'}});
	}
}