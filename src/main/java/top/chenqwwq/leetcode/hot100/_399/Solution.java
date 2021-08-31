package top.chenqwwq.leetcode.hot100._399;

import java.util.*;

/**
 * <p>
 * [["a","b"],["b","c"],["bc","cd"]]
 * [1.5,2.5,5.0]
 * [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
 * [["a","b"]]
 * [0.5]
 * [["a","b"],["b","a"],["a","c"],["x","y"]]
 *
 * @author chen
 * @date 2021-08-31
 **/
public class Solution {
	private static final double INF = -1.0d;
	Map<String, Map<String, Double>> map;

	public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
		map = new HashMap<>();
		for (int i = 0; i < equations.size(); i++) {
			final List<String> flags = equations.get(i);
			String a = flags.get(0), b = flags.get(1);
			final double res = values[i];
			final Map<String, Double> orDefault = map.getOrDefault(a, new HashMap<>());
			orDefault.put(b, res);
			map.put(a, orDefault);

			final Map<String, Double> orDefault1 = map.getOrDefault(b, new HashMap<>());
			orDefault1.put(a, 1 / res);
			map.put(b, orDefault1);
		}

		final int m = queries.size();
		double[] ans = new double[m];
		for (int i = 0; i < m; i++) {
			final List<String> query = queries.get(i);
			final String a = query.get(0), b = query.get(1);
			if (!map.containsKey(a) || !map.containsKey(b)) {
				ans[i] = INF;
			} else if (a.equals(b)) {
				ans[i] = 1d;
			} else {
				ans[i] = getAns(query.get(0), query.get(1), new HashSet<>());
			}
		}
		return ans;
	}

	private Double getAns(String a, String b, Set<String> exists) {
		final Map<String, Double> hash = map.get(a);
		if (hash == null) {
			return INF;
		}
		if (hash.containsKey(b)) {
			return hash.get(b);
		}
		exists.add(a);
		for (Map.Entry<String, Double> entry : hash.entrySet()) {
			if (exists.contains(entry.getKey())) {
				continue;
			}
			final Double value = entry.getValue();
			final Double ans = getAns(entry.getKey(), b, exists);
			if (ans != INF) {
				return value * ans;
			}
		}
		return INF;
	}
}