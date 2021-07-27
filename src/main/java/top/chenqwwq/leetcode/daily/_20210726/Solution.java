package top.chenqwwq.leetcode.daily._20210726;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1713. Minimum Operations to Make a Subsequence
 * You are given an array target that consists of distinct integers and another integer array arr that can have duplicates.
 * <p>
 * In one operation, you can insert any integer at any position in arr. For example, if arr = [1,4,1,2], you can add 3 in the middle and make it [1,4,3,1,2]. Note that you can insert the integer at the very beginning or end of the array.
 * <p>
 * Return the minimum number of operations needed to make target a subsequence of arr.
 * <p>
 * A subsequence of an array is a new array generated from the original array by deleting some elements (possibly none) without changing the remaining elements' relative order. For example, [2,7,4] is a subsequence of [4,2,3,7,2,1,4] (the underlined elements), while [2,4,2] is not.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: target = [5,1,3], arr = [9,4,2,3,4]
 * Output: 2
 * Explanation: You can add 5 and 1 in such a way that makes arr = [5,9,4,1,2,3,4], then target will be a subsequence of arr.
 * Example 2:
 * <p>
 * Input: target = [6,4,8,1,3,2], arr = [4,7,6,2,3,8,6,1]
 * Output: 3
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= target.length, arr.length <= 105
 * 1 <= target[i], arr[i] <= 109
 * target contains no duplicates.
 *
 * @author chen
 * @date 2021-07-26
 **/
public class Solution {
	public int minOperations(int[] target, int[] arr) {
		// 离散化处理
		Map<Integer, Integer> hash = new HashMap<>();
		final int n = target.length;
		for (int i = 0; i < n; i++) {
			hash.put(target[i], i);
		}

		// 获取相关数组
		int cnt = 0;
		List<Integer> nums = new ArrayList<>();
		for (int k : arr) {
			if (hash.containsKey(k)) {
				nums.add(hash.get(k));
				cnt++;
			}
		}
		if (cnt == 0) {
			return target.length;
		}

		// 求最长递增子序列
		int ans = 1;
		int[] dp = new int[cnt];
		dp[0] = 1;
		for (int i = 1; i < cnt; i++) {
			int max = 1;
			for (int j = i - 1; j >= 0; --j) {
				if (nums.get(j) < nums.get(i)) {
					max = Math.max(dp[j] + 1, max);
				}
			}
			dp[i] = max;
			ans = Math.max(ans, max);
		}
		return n - ans;
	}
}