package top.chenqwwq.leetcode.contest.biweek._64._2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author chen
 * @date 2021/10/30
 **/
public class Solution {
	public int maxTwoEvents(int[][] events) {
		final int n = events.length;
		Arrays.sort(events, Comparator.comparingInt(o -> o[0]));
		int ans = 0;
		TreeMap<Integer, Integer> map = new TreeMap<>();
		int max = events[n - 1][2];
		map.put(events[n - 1][0], max);
		ans = Math.max(ans, events[n - 1][2]);
		for (int i = n - 2; i >= 0; i--) {
			max = Math.max(max, events[i][2]);
			map.put(events[i][0], max);
			ans = Math.max(ans, events[i][2]);
		}

		for (int[] event : events) {
			final Map.Entry<Integer, Integer> entry = map.higherEntry(event[1]);
			if (entry == null) {
				continue;
			}
			ans = Math.max(event[2] + entry.getValue(), ans);
		}
		return ans;
	}
}