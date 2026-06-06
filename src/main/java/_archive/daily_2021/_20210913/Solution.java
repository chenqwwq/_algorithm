package top.chenqwwq.leetcode.daily._2021._20210913;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chen
 * @date 2021/9/13
 **/
public class Solution {
	// <distance,<from,to list>>

	public int numberOfBoomerangs(int[][] points) {
		if (points.length < 3) {
			return 0;
		}

		final int n = points.length;
		int ans = 0;
		// 枚举中间节点
		for (int[] p0 : points) {
			Map<Integer, Integer> map = new HashMap<>();
			for (int[] p1 : points){
				int distance = (p0[0] - p1[0]) * (p0[0] - p1[0]) + (p0[1] - p1[1]) * (p0[1] - p1[1]);
				map.put(distance, map.getOrDefault(distance, 0) + 1);
			}

			for (int v : map.values()) {
				ans += v * (v - 1);
			}
		}
		return ans;

	}
}