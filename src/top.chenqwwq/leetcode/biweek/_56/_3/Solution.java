package top.chenqwwq.leetcode.biweek._56._3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author chen
 * @date 2021/7/10
 **/
public class Solution {

	int[] x = new int[]{1, -1, 0, 0};
	int[] y = new int[]{0, 0, 1, -1};

	public int nearestExit(char[][] maze, int[] entrance) {
		final int rows = maze.length, cols = maze[0].length;
		Queue<int[]> queue = new LinkedList<>();
		queue.add(entrance);
		boolean[][] exist = new boolean[rows][cols];
		exist[entrance[0]][entrance[1]] = true;
		int ans = 0;
		while (!queue.isEmpty()) {
			ans++;
			final int size = queue.size();
			for (int j = 0; j < size; j++) {
				final int[] poll = queue.poll();
				for (int i = 0; i < 4; i++) {
					int a = poll[0] + x[i], b = poll[1] + y[i];
					if (a < 0 || b < 0 || a >= rows || b >= cols || maze[a][b] == '+' || exist[a][b]) {
						continue;
					}
					exist[a][b] = true;
					if (a == 0 || b == 0 || a == rows - 1 || b == cols - 1) {
						return ans;
					}
					queue.add(new int[]{a, b});
				}
			}
		}
		return -1;
	}
}