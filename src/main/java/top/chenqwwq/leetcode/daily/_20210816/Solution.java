package top.chenqwwq.leetcode.daily._20210816;

/**
 * 526. Beautiful Arrangement
 * Suppose you have n integers labeled 1 through n. A permutation of those n integers perm (1-indexed) is considered a beautiful arrangement if for every i (1 <= i <= n), either of the following is true:
 * <p>
 * perm[i] is divisible by i.
 * i is divisible by perm[i].
 * Given an integer n, return the number of the beautiful arrangements that you can construct.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 2
 * Output: 2
 * Explanation:
 * The first beautiful arrangement is [1,2]:
 * - perm[1] = 1 is divisible by i = 1
 * - perm[2] = 2 is divisible by i = 2
 * The second beautiful arrangement is [2,1]:
 * - perm[1] = 2 is divisible by i = 1
 * - i = 2 is divisible by perm[2] = 1
 * Example 2:
 * <p>
 * Input: n = 1
 * Output: 1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 15
 *
 * @author chen
 * @date 2021-08-16
 **/
public class Solution {
	int n;

	public int countArrangement(int _n) {
		n = _n;
		final int[] nums = new int[n + 1];
		return dfs(nums, 1);
	}

	public int dfs(int[] nums, int curr) {
		if (curr == n + 1) {
			return 1;
		}
		int ans = 0;
		for (int i = 1; i <= n; i++) {
			if (nums[i] != 0) {
				continue;
			}
			if (i % curr == 0 || curr % i == 0) {
				nums[i] = curr;
				ans += dfs(nums, curr + 1);
				nums[i] = 0;
			}
		}
		return ans;
	}
}