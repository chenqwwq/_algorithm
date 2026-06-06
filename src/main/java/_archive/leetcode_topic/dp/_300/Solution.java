package top.chenqwwq.leetcode.topic.dp._300;

/**
 * 300. Longest Increasing Subsequence
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 * <p>
 * A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * Example 2:
 * <p>
 * Input: nums = [0,1,0,3,2,3]
 * Output: 4
 * Example 3:
 * <p>
 * Input: nums = [7,7,7,7,7,7,7]
 * Output: 1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 2500
 * -104 <= nums[i] <= 104
 * <p>
 * <p>
 * Follow up: Can you come up with an algorithm that runs in O(n log(n)) time complexity?
 *
 * @author chen
 * @date 2021-05-24
 **/
public class Solution {
	public int lengthOfLIS(int[] nums) {
		// dp 使用贪心+2分优化
		final int n = nums.length;
		int[] dp = new int[n];
		dp[0] = nums[0];
		int ans = 1;

		for (int i = 1; i < n; i++) {
			// 在 dp 区间里面找第一个比nums大的数
			int left = 0, right = ans;
			while (left < right) {
				final int mid = (left + right) >> 1;
				if (dp[mid] < nums[i]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
			dp[left] = nums[i];
			if (right == ans) {
				ans++;
			}
		}
		return ans;
	}
//	public int lengthOfLIS(int[] nums) {
//		final int n = nums.length;
//		int[] dp = new int[n];
//
//		int ans = 1;
//		dp[0] = 1;
//		for (int i = 1; i < n; i++) {
//			int tmp = 1;
//			for (int j = i - 1; j >= 0; j--) {
//				if (nums[i] > nums[j]) {
//					tmp = Math.max(dp[j] + 1, tmp);
//				}
//			}
//			dp[i] = tmp;
//			if (tmp > ans) {
//				ans = tmp;
//			}
//		}
//
//		return ans;
//	}
}