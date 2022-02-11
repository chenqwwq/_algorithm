package top.chenqwwq.leetcode.lcof._2021._29;

import javax.sound.midi.Soundbank;

/**
 * todo:
 *
 * @author chen
 * @date 2021/6/6
 **/
public class Solution {
	public int[] spiralOrder(int[][] matrix) {
		final int rows = matrix.length;
		if (rows == 0) {
			return new int[]{};
		}
		int cols = matrix[0].length;
		final int[] ans = new int[cols * rows];
		int cur = 0;
		for (int i = 0; i <= rows >> 1; i++) {
			int x = i, y = i;
			while (y < cols - i) {
				ans[cur++] = matrix[x][y++];
			}
			--y;
			if (++x >= rows) {
				break;
			}
			while (x < rows - i) {
				ans[cur++] = matrix[x++][y];
			}
			--x;
			if (--y < i) {
				break;
			}
			while (y >= i) {
				ans[cur++] = matrix[x][y--];
			}
			++y;
			if (--x < i) {
				break;
			}
			while (x > i) {
				ans[cur++] = matrix[x--][y];
			}
		}
		return ans;
	}
}