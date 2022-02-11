package top.chenqwwq.leetcode.daily._20211107;

/**
 * @author chen
 * @date 2021/11/7
 **/
public class Solution {
	public int maxCount(int m, int n, int[][] ops) {
		if (ops.length == 0) {
			return m * n;
		}
		int mi = Integer.MAX_VALUE, mj = Integer.MAX_VALUE;
		for (int[] op : ops) {
			mi = Math.min(op[0], mi);
			mj = Math.min(op[1], mj);
		}
		return mi * mj;
	}
}