package top.chenqwwq.leetcode.biweek._67._1;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author chenbingxin
 * @date 2021/12/11
 **/
public class Solution {
	public int[] maxSubsequence(int[] nums, int k) {
		final int n = nums.length;
		if (n <= k) {
			return nums;
		}

		int[] sorted = new int[n];
		System.arraycopy(nums, 0, sorted, 0, n);
		Arrays.sort(sorted);
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < k; i++) {
			map.put(sorted[n - 1 - i], map.getOrDefault(sorted[n - 1 - i], 0) + 1);
		}

		int[] ans = new int[k];
		for (int i = 0, idx = 0; i < n; i++) {
			if (map.getOrDefault(nums[i], 0) > 0) {
				ans[idx++] = nums[i];
				map.put(nums[i], map.get(nums[i]) - 1);
			}
		}
		return ans;
	}
}