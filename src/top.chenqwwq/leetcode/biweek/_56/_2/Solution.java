package top.chenqwwq.leetcode.biweek._56._2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * [["+",".","+","+","+","+","+"],
 * ["+",".","+",".",".",".","+"],
 * ["+",".","+",".","+",".","+"],
 * ["+",".",".",".","+",".","+"],
 * ["+","+","+","+","+",".","+"]]
 * [3,2]
 *
 * @author chen
 * @date 2021/7/10
 **/
public class Solution {

	int[] x = new int[]{1, -1, 0, 0};
	int[] y = new int[]{0, 0, 1, -1};

	public int nearestExit(char[][] maze, int[] entrance) {
		final int rows = maze.length, cols = maze[0].length;
		int[][] dists = new int[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				dists[i][j] = Integer.MAX_VALUE;
			}
		}
		Queue<int[]> queue = new LinkedList<>();
		queue.add(entrance);
		dists[entrance[0]][entrance[1]] = 0;
		boolean[][] exist = new boolean[rows][cols];
		while (!queue.isEmpty()) {
			final int[] poll = queue.poll();
			exist[poll[0]][poll[1]] = true;
			for (int i = 0; i < 4; i++) {
				int a = poll[0] + x[i], b = poll[1] + y[i];
				if (a < 0 || b < 0 || a >= rows || b >= cols || maze[a][b] == '+' || exist[a][b]) {
					continue;
				}
				if (dists[a][b] > dists[poll[0]][poll[1]] + 1) {
					dists[a][b] = dists[poll[0]][poll[1]] + 1;
					if (a == 0 || b == 0 || a == rows - 1 || b == cols - 1) {
						return dists[a][b];
					}
					queue.add(new int[]{a, b});
				}
			}
		}
		return -1;
	}
}