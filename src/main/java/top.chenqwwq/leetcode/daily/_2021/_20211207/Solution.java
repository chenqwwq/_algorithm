package top.chenqwwq.leetcode.daily._2021._20211207;

import java.util.LinkedList;
import java.util.Queue;

/**
 * [[1,2,1,2,1,2],
 * [2,2,2,2,1,2],
 * [1,2,2,2,1,2]]
 *
 * @author chenbingxin
 * @date 2021/12/7
 **/
public class Solution {

	private static final int INF = 0;

	int[] xc = {1, -1, 0, 0}, yc = {0, 0, 1, -1};
	int[][] grid;
	boolean[][] visit;

	public int[][] colorBorder(int[][] _grid, int row, int col, int color) {
		this.grid = _grid;
		visit = new boolean[grid.length][grid[0].length];

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{row, col});
		visit[row][col] = true;

		while (!queue.isEmpty()) {
			final int[] poll = queue.poll();
			boolean needDyeing = false;
			for (int i = 0; i < 4; i++) {
				int x = poll[0] + xc[i], y = poll[1] + yc[i];
				if(!valid(x,y)){
					needDyeing = true;
					continue;
				}
				if (grid[x][y] == INF || visit[x][y]) {
					continue;
				}
				if (grid[x][y] != grid[row][col]){
					needDyeing = true;
					continue;
				}
				visit[x][y]= true;
				queue.add(new int[]{x, y});
			}
			if(needDyeing){
				grid[poll[0]][poll[1]] = INF;
			}

		}

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if(grid[i][j] == INF){
					grid[i][j] = color;
				}
			}
		}
		return grid;
	}

	private boolean valid(int x, int y) {
		return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
	}
}