package top.chenqwwq.leetcode.contest.biweek._57._3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chen
 * @date 2021/7/24
 **/
public class Solution {
	public List<List<Long>> splitPainting(int[][] segments) {
		Map<Integer, Long> map = new HashMap<>();

		for (int[] segment : segments) {
			map.put(segment[0], map.getOrDefault(segment[0], 0L) + segment[2]);
			map.put(segment[1], map.getOrDefault(segment[1], 0L) - segment[2]);
		}

		List<Integer> keys = new ArrayList<>(map.keySet());
		keys.sort(Integer::compareTo);


		List<List<Long>> ans = new ArrayList<>();
		long curr = 0;
		for (int i = 0; i < keys.size(); i++) {
			List<Long> l = new ArrayList<>();
			final Integer start = keys.get(i);
			curr += map.get(start);
			if (curr == 0) {
				continue;
			}
			l.add((long) start);
			l.add((long) keys.get(i + 1));
			l.add(curr);
			ans.add(l);
		}
		return ans;

	}
}