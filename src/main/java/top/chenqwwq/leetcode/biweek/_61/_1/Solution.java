package top.chenqwwq.leetcode.biweek._61._1;

import java.util.Arrays;

/**
 * @author chen
 * @date 2021/9/18
 **/
public class Solution {
	public int minOperations(int[] nums) {
		int total = nums.length;
		int ans = total - 1;
		nums = Arrays.stream(nums).distinct().toArray();
		final int n = nums.length;
		Arrays.sort(nums);
		for (int i = 0; i < n; i++) {
			int r = i + 1, cnt = 1;
			while (r < n && nums[r] - nums[i] < total) {
				cnt++;
				r++;
			}
			ans = Math.min(ans, total - cnt);
		}
		return ans;
	}

	public static void main(String[] args) {
		new Solution().minOperations(new int[]{8, 10, 16, 18, 10, 10, 16, 13, 13, 16});
	}
}