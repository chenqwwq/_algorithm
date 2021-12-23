package top.chenqwwq.leetcode.weekly._246._3;

/**
 * @author chen
 * @date 2021/6/20
 **/
public class Solution {
	int rows, cols;

	public int countSubIslands(int[][] grid1, int[][] grid2) {
		rows = grid1.length;
		cols = grid1[0].length;
		boolean[][] exist = new boolean[rows][cols];
		int ans = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (exist[i][j]) {
					continue;
				}
				if (grid2[i][j] == 1 && dfs(grid1, grid2, i, j, exist)) {
					ans++;
				}
			}
		}
		return ans;
	}


	public boolean dfs(int[][] grid1, int[][] grid2, int x, int y, boolean[][] exist) {
		if (x < 0 || x >= rows || y < 0 || y >= cols || exist[x][y]) {
			return true;
		}
		if (grid2[x][y] != 1) {
			return true;
		}
		exist[x][y] = true;
		final boolean dfs = dfs(grid1, grid2, x + 1, y, exist);
		final boolean dfs2 = dfs(grid1, grid2, x, y + 1, exist);
		final boolean dfs3 = dfs(grid1, grid2, x - 1, y, exist);
		final boolean dfs4 = dfs(grid1, grid2, x, y - 1, exist);
		return grid1[x][y] == 1 && dfs && dfs2 && dfs3 && dfs4;
	}

	public static void main(String[] args) {
		new Solution().countSubIslands(new int[][]{
				{1, 1, 1, 1, 0, 0},
				{1, 1, 0, 1, 0, 0},
				{1, 0, 0, 1, 1, 1},
				{1, 1, 1, 0, 0, 1},
				{1, 1, 1, 1, 1, 0},
				{1, 0, 1, 0, 1, 0},
				{0, 1, 1, 1, 0, 1},
				{1, 0, 0, 0, 1, 1},
				{1, 0, 0, 0, 1, 0},
				{1, 1, 1, 1, 1, 0}
		}, new int[][]{
				{1, 1, 1, 1, 0, 1},
				{0, 0, 1, 0, 1, 0},
				{1, 1, 1, 1, 1, 1},
				{0, 1, 1, 1, 1, 1},
				{1, 1, 1, 0, 1, 0},
				{0, 1, 1, 1, 1, 1},
				{1, 1, 0, 1, 1, 1},
				{1, 0, 0, 1, 0, 1},
				{1, 1, 1, 1, 1, 1},
				{1, 0, 0, 1, 0, 0}
		});
	}
}