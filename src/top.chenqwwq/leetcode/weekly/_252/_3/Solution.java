package top.chenqwwq.leetcode.weekly._252._3;

import java.util.Arrays;

/**
 * @author chen
 * @date 2021/8/1
 **/
public class Solution {
	public long numberOfWeeks(int[] milestones) {
		final int n = milestones.length;

		Arrays.sort(milestones);

		long total = 0;
		for (int i = 0; i < n - 1; i++) {
			total += milestones[i];
		}
		return total + Math.min(milestones[n-1],total+1);
	}
}