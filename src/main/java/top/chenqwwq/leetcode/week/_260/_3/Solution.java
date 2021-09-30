package top.chenqwwq.leetcode.week._260._3;

/**
 * 5883. 判断单词是否能放入填字游戏内 显示英文描述
 * 通过的用户数57
 * 尝试过的用户数91
 * 用户总通过次数57
 * 用户总提交次数138
 * 题目难度Medium
 * 给你一个 m x n 的矩阵 board ，它代表一个填字游戏 当前 的状态。填字游戏格子中包含小写英文字母（已填入的单词），表示 空 格的 ' ' 和表示 障碍 格子的 '#' 。
 * <p>
 * 如果满足以下条件，那么我们可以 水平 （从左到右 或者 从右到左）或 竖直 （从上到下 或者 从下到上）填入一个单词：
 * <p>
 * 该单词不占据任何 '#' 对应的格子。
 * 每个字母对应的格子要么是 ' ' （空格）要么与 board 中已有字母 匹配 。
 * 如果单词是 水平 放置的，那么该单词左边和右边 相邻 格子不能为 ' ' 或小写英文字母。
 * 如果单词是 竖直 放置的，那么该单词上边和下边 相邻 格子不能为 ' ' 或小写英文字母。
 * 给你一个字符串 word ，如果 word 可以被放入 board 中，请你返回 true ，否则请返回 false 。
 *
 * @author chen
 * @date 2021-09-26
 **/
public class Solution {
	int n, m;
	char[][] board;


	int[] cx = new int[]{-1, 1, 0, 0};
	int[] cy = new int[]{0, 0, -1, 1};

	public boolean placeWordInCrossword(char[][] _board, String word) {
		board = _board;
		n = board.length;
		m = board[0].length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				// 判断是否可以作为起点
				if ((i == 0 || i == n - 1 || j == 0 || j == m - 1) && (board[i][j] == word.charAt(0) || board[i][j] == ' ')) {
					// 上下左右一起扫
					for (int q = 0; q < 4; q++) {
						int len = 1, x = i, y = j;
						if (!check(x - cx[q], y - cy[q])) {
							continue;
						}
						while (len < word.length()) {
							x += cx[q];
							y += cy[q];
							if (check(x, y)) {
								break;
							}
							if ((board[x][y] != ' ' && board[x][y] != word.charAt(len))) {
								break;
							}
							len++;
						}
						if (len == word.length() && check(x + cx[q], y + cy[q])) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	public boolean check(int x, int y) {
		return x < 0 || y < 0 || x >= n || y >= m || board[x][y] == '#';
	}

	public static void main(String[] args) {
		new Solution().placeWordInCrossword(new char[][]{
				{'#', ' ', '#'},
				{' ', ' ', '#'},
				{'#', 'c', ' '}

		}, "abc");

		new Solution().placeWordInCrossword(new char[][]{
						{'z', ' '},
						{'z', ' '}},
				"a");
	}

}
