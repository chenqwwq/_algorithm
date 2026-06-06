package top.chenqwwq.leetcode.archive.lcof2._91;

/**
 * @author chenbingxin
 * @date 2021/12/22
 **/
public class Solution {
	public int minCost(int[][] costs) {
		int r = 0, b = 0, g = 0;
		for (int[] cost : costs) {
			final int rt = cost[0] + Math.min(b, g);
			final int bt = cost[1] + Math.min(r, g);
			final int gt = cost[2] + Math.min(r, b);
			r = rt;
			b = bt;
			g = gt;
		}
		return Math.min(r, Math.min(b, g));
	}
}
