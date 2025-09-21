package top.chenqwwq.leetcode.topic.union_find._130;

/**
 * 130. 被围绕的区域
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：board = [
 * ["X","X","X","X"],
 * ["X","O","O","X"],
 * ["X","X","O","X"],
 * ["X","O","X","X"]]
 * 输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 * 解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 * 示例 2：
 * <p>
 * 输入：board = [["X"]]
 * 输出：[["X"]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 200
 * board[i][j] 为 'X' 或 'O'
 *
 * @author chen
 * @date 2021-06-08
 **/
public class Solution {

	private int n;
	private int m;

	class UnionFind {
		int[] data;

		public UnionFind(char[][] board) {
			n = board.length;
			m = board[0].length;
			data = new int[n * m];
			for (int i = 0; i < data.length; i++) {
				data[i] = i;
			}

			for (int i = 1; i < n - 1; i++) {
				for (int j = 1; j < m - 1; j++) {
					if (board[i][j] != 'O') {
						continue;
					}
					final int index = getIndex(i, j);
					if (board[i - 1][j] == 'O') {
						merge(index, getIndex(i - 1, j));
					}
					if (board[i + 1][j] == 'O') {
						merge(index, getIndex(i + 1, j));
					}
					if (board[i][j + 1] == 'O') {
						merge(index, getIndex(i, j + 1));
					}
					if (board[i][j - 1] == 'O') {
						merge(index, getIndex(i, j - 1));
					}
				}
			}

			for (int i = 1; i < n - 1; i++) {
				for (int j = 1; j < m - 1; j++) {
					if (board[i][j] != 'O') {
						continue;
					}
					if (!check(find(getIndex(i, j)))) {
						board[i][j] = 'X';
					}
				}
			}
		}

		// 这里选取边缘节点作为父节点
		private void merge(int x, int y) {
			int i = find(x), j = find(y);
			if (i != j) {
				if (check(i)) {
					data[j] = i;
				} else {
					data[i] = j;
				}
			}
		}

		private int find(int n) {
			if (data[n] != n) {
				data[n] = find(data[n]);
			}
			return data[n];
		}
	}

	// 判断 x 是否在边缘
	private boolean check(int x) {
		int i = x / m, j = x % m;
		return i == 0 || j == 0 || i == n - 1 || j == m - 1;
	}

	private int getIndex(int x, int y) {
		return x * m + y;
	}

	public void solve(char[][] board) {
		new UnionFind(board);
	}
}