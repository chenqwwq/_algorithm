package top.chenqwwq.leetcode.weekly._249._1;

/**
 * @author chen
 * @date 2021/7/11
 **/
public class Solution {
	public int[] getConcatenation(int[] nums) {
		final int n = nums.length;
		int[] ans = new int[n << 1];
		for (int i = 0; i < n; i++) {
			ans[i] = ans[i + n] = nums[i];
		}
		return ans;
	}
}