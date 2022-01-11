package top.chenqwwq.leetcode.weekly._258._2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chen
 * @date 2021/9/12
 **/
public class Solution {
	public long interchangeableRectangles(int[][] rectangles) {
		final int n = rectangles.length;
		Map<Double, Integer> map = new HashMap<>();
		for (int[] rectangle : rectangles) {
			Double key = 1.0d * rectangle[0] / rectangle[1];
			map.put(key, map.getOrDefault(key, 0) + 1);
		}

		long ans = 0;
		for (int v : map.values()) {
			ans += (long) v * (v-1) / 2;
		}
		return ans;
	}
}