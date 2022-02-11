package top.chenqwwq.leetcode.daily._20210910;

/**
 * @author chen
 * @date 2021-09-10
 **/
public class Solution {
	public int chalkReplacer(int[] chalk, int k) {
		int n = chalk.length;
		long[] pre = new long[n + 1];
		for (int i = 0; i < n; i++) {
			pre[i + 1] = pre[i] + chalk[i];
		}

		k %= pre[n];

		// 二分
		int left = 0, right = n;
		while (left <= right) {
			int mid = (left + right) >> 1;
			if (pre[mid] <= k) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return left - 1;
	}
}