package top.chenqwwq.leetcode.biweek._65._3;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author chen
 * @date 2021/11/15
 **/
public class Solution {
	public int[] maximumBeauty(int[][] items, int[] queries) {
		Arrays.sort(items, Comparator.comparingInt(o -> o[0]));
		final int n = items.length;
		for (int i = 1; i < n; i++) {
			items[i][1] = Math.max(items[i - 1][1], items[i][1]);
		}

		final int k = queries.length;
		final int[] ans = new int[k];
		for (int i = 0; i < k; i++) {
			final int target = queries[i];
			int l = 0, r = n;
			while (l < r) {
				final int mid = (l + r) >> 1;
				if (target < items[mid][0]) {
					r = mid;
				} else {
					l = mid + 1;
				}
			}
			ans[i] = l == 0 ? 0 : items[l - 1][1];
		}
		return ans;
	}
}