package top.chenqwwq.leetcode.archive.lcp._2021._1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chen
 * @date 2021/9/11
 **/
public class Solution {
	public int minimumSwitchingTimes(int[][] source, int[][] target) {
		int n = source.length, m = source[0].length;
		Map<Integer, Integer> hash = new HashMap<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				hash.put(source[i][j], hash.getOrDefault(source[i][j], 0) + 1);
				hash.put(target[i][j], hash.getOrDefault(target[i][j], 0) - 1);
			}
		}

		int ans = 0;
		for (int num : hash.values()) {
			ans += Math.abs(num);
		}
		return ans >> 1;
	}
}