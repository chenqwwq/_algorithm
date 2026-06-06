package top.chenqwwq.leetcode.daily._2021._20211026;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chen
 * @date 2021/10/26
 **/
public class Solution {
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		final int n = nums2.length;
		if (n == 0) {
			return new int[]{};
		}
		int[] stack = new int[n];
		Map<Integer, Integer> map = new HashMap<>();
		stack[0] = nums2[0];
		int idx = 0;
		for (int i = 1; i < n; i++) {
			while (idx >= 0 && nums2[i] > stack[idx]) {
				map.put(stack[idx--], nums2[i]);
			}
			stack[++idx] = nums2[i];
		}

		final int m = nums1.length;
		int[] ans = new int[m];
		for (int i = 0; i < m; i++) {
			ans[i] = map.getOrDefault(nums1[i], -1);
		}
		return ans;
	}
}