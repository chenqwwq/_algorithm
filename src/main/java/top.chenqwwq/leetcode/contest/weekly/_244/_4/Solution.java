package top.chenqwwq.leetcode.contest.weekly._244._4;

import java.util.Arrays;

/**
 * @author chen
 * @date 2021/6/6
 **/
public class Solution {
	static final int MOD = 1000000007;

	public int minWastedSpace(int[] packages, int[][] boxes) {
		Arrays.sort(packages);
		int min = Integer.MAX_VALUE;
		for (int[] box : boxes) {
			final int waste = getWaste(packages, box);
			if (waste == -1) {
				continue;
			}
			min = Math.min(min, waste);
		}
		return min == Integer.MAX_VALUE ? -1 : min;
	}

	public int getWaste(int[] packages, int[] boxes) {
		int ans = 0, curr = 0, pack = 0;
		Arrays.sort(boxes);
		for (; curr < packages.length; curr++) {
			while (pack < boxes.length && packages[curr] > boxes[pack]) {
				pack++;
			}
			if (pack >= boxes.length) {
				return -1;
			}
			ans = (ans + (boxes[pack] - packages[curr])) % MOD;
		}
		return ans;
	}
}