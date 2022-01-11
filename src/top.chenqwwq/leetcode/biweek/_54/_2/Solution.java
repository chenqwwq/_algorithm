package top.chenqwwq.leetcode.biweek._54._2;

/**
 * @author chen
 * @date 2021/6/12
 **/
public class Solution {
	public int chalkReplacer(int[] chalk, int k) {
		final int n = chalk.length;
		int[] sum = new int[n];
		sum[0] = chalk[0];
		for (int i = 1; i < n; i++) {
			sum[i] = sum[i - 1] + chalk[i];
			if (sum[i] > k) {
				return i;
			}
		}
		final int target = k % sum[n - 1];
		int left = 0, right = n - 1;
		while (left <= right) {
			int mid = (left + right) >> 1;
			if (sum[mid] > target) {
				right = mid - 1;
			} else if (sum[mid] < target) {
				left = mid + 1;
			} else {
				return mid + 1;
			}
		}
		return left;
	}
}