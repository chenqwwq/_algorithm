package top.chenqwwq.leetcode.biweek._53._3;

import javax.swing.*;
import java.util.*;

/**
 * @author chen
 * @date 2021/5/29
 **/
public class Solution {
	Set<Integer> set = new HashSet<>();
	int m, n, max;


	public int[] getBiggestThree(int[][] grid) {
		m = grid.length;
		n = grid[0].length;
		max = Math.min(m, n) >> 1;
		int[][] sum1 = new int[m + 1][n + 1], sum2 = new int[m + 1][n + 1];
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				set.add(grid[i - 1][j - 1]);
				sum1[i][j] = (j + 1 <= n ? sum1[i - 1][j + 1] : 0) + grid[i - 1][j - 1];
				sum2[i][j] = sum2[i - 1][j - 1] + grid[i - 1][j - 1];
			}
		}

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				for (int len = 1; len <= max; len++) {
					if (!check(i, j, len)) {
						break;
					}

					set.add(getRangeSum(i + 1, j + 1, len, sum1, sum2));
				}
			}
		}

		List<Integer> list = new ArrayList<>(set);
		list.sort(Collections.reverseOrder());
		final int size = Math.min(3, list.size());
		int[] ans = new int[size];
		for (int j = 0; j < size; j++) {
			ans[j] = list.get(j);
		}
		return ans;
	}

	public int getRangeSum(int x, int y, int len, int[][] sum1, int[][] sum2) {
		int l1 = sum1[x + len][y - len] - sum1[x][y];
		int l2 = sum2[x + len][y + len] - sum2[x - 1][y - 1];
		int l4 = sum1[x + 2 * len][y] - sum1[x + len][y + len];
		int l3 = sum2[x + 2 * len - 1][y - 1] - sum2[x + len][y - len];
		return l1 + l2 + l3 + l4;
	}


	public boolean check(int x, int y, int len) {
		return !(y - len < 0 || y + len >= n || x + 2 * len >= m);
	}
}