package top.chenqwwq.leetcode.contest.weekly._241._1;

/**
 * @author chen
 * @date 2021/5/16
 **/
public class Solution {
	int ans = 0;

	public int subsetXORSum(int[] nums) {
		dfs(nums, 0, 0);
		return ans;
	}

	public void dfs(int[] src, int idx, int curr) {
		if (idx == src.length) {
			return;
		}

		// 不和当前的值XOR
		dfs(src, idx + 1, curr);

		// 和当前值 XOR
		final int i = curr ^ src[idx];
		ans += i;
		dfs(src, idx + 1, i);
	}
}