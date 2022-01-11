package top.chenqwwq.leetcode.weekly._259._3;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chen
 * @date 2021/9/19
 **/
public class DetectSquares {

	Map<Integer, Map<Integer, Integer>> x = new HashMap<>();
	Map<Integer, Map<Integer, Integer>> y = new HashMap<>();
	Map<String, Integer> o = new HashMap<>();


	public DetectSquares() {

	}

	public void add(int[] point) {
		final Map<Integer, Integer> orDefault = x.getOrDefault(point[0], new HashMap<>());
		orDefault.put(point[1], orDefault.getOrDefault(point[1], 0) + 1);
		x.put(point[0], orDefault);

		final String key = getKey(point[0], point[1]);
		o.put(key, o.getOrDefault(key, 0) + 1);
	}

	private String getKey(int x, int y) {
		return x + "_" + y;
	}

	public int count(int[] point) {
		// 查询同个x轴上不同的y
		final Map<Integer, Integer> xLine = x.get(point[0]);
		if (xLine == null) {
			return 0;
		}
		int ans = 0;
		for (int y : xLine.keySet()) {
			if (y == point[1]) {
				continue;
			}
			final int len = Math.abs(y - point[1]), cnt = xLine.get(y);
			final int x1 = point[0] - len, x2 = point[0] + len;
			ans += (o.getOrDefault(getKey(x1, y), 0) * cnt * o.getOrDefault(getKey(x1, point[1]), 0));
			ans += (o.getOrDefault(getKey(x2, y), 0) * cnt * o.getOrDefault(getKey(x2, point[1]), 0));
		}

		return ans;
	}
}