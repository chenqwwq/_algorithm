package top.chenqwwq.leetcode.biweek._60._1;

/**
 * @author chen
 * @date 2021/9/4
 **/
public class Solution {
	public int findMiddleIndex(int[] nums) {
		final int n = nums.length;
		if (n == 1) {
			return 0;
		}

		int[] sum = new int[n + 1];
		for (int i = 0; i < n; i++) {
			sum[i + 1] = sum[i] + nums[i];
		}

		//  [2,3,-1,8,4]
		//  0 2 5 4 12 16
		for (int i = 1; i <= n; i++) {
			if (sum[i - 1] == sum[n] - sum[i]) {
				return i - 1;
			}
		}
		return -1;
	}
}