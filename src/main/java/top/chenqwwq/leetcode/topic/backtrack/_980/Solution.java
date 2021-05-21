package top.chenqwwq.leetcode.topic.backtrack._980;

/**
 * 980. 不同路径 III
 * 在二维网格 grid 上，有 4 种类型的方格：
 * <p>
 * 1 表示起始方格。且只有一个起始方格。
 * 2 表示结束方格，且只有一个结束方格。
 * 0 表示我们可以走过的空方格。
 * -1 表示我们无法跨越的障碍。
 * 返回在四个方向（上、下、左、右）上行走时，从起始方格到结束方格的不同路径的数目。
 * <p>
 * 每一个无障碍方格都要通过一次，但是一条路径中不能重复通过同一个方格。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
 * 输出：2
 * 解释：我们有以下两条路径：
 * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
 * 2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
 * 示例 2：
 * <p>
 * 输入：[[1,0,0,0],[0,0,0,0],[0,0,0,2]]
 * 输出：4
 * 解释：我们有以下四条路径：
 * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
 * 2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
 * 3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
 * 4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)
 * 示例 3：
 * <p>
 * 输入：[[0,1],[2,0]]
 * 输出：0
 * 解释：
 * 没有一条路能完全穿过每一个空的方格一次。
 * 请注意，起始和结束方格可以位于网格中的任意位置。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= grid.length * grid[0].length <= 20
 *
 * @author chen
 * @date 2021-05-21
 **/
public class Solution {
	int sx, sy, ex, ey, cnt = 0;
	int ans = 0;
	int[][] grid;
	boolean[][] visited;

	int[] x = new int[]{1, 0, 0, -1};
	int[] y = new int[]{0, 1, -1, 0};

	public int uniquePathsIII(int[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					sx = i;
					sy = j;
				} else if (grid[i][j] == 2) {
					ex = i;
					ey = j;
				} else if (grid[i][j] == 0) {
					cnt++;
				}
			}
		}
		this.visited = new boolean[grid.length][grid[0].length];
		this.grid = grid;

		bt(sx, sy, -1);
		return ans;
	}

	public void bt(int cx, int cy, int cc) {
		if (cx < 0 || cy < 0 || cx >= grid.length || cy >= grid[0].length || visited[cx][cy] || grid[cx][cy] == -1) {
			return;
		}
		if (cx == ex && cy == ey) {
			if (cc == cnt) {
				ans++;
			}
			return;
		}

		visited[cx][cy] = true;
		for (int i = 0; i < 4; i++) {
			bt(cx + x[i], cy + y[i], cc + 1);
		}
		visited[cx][cy] = false;
	}
}








