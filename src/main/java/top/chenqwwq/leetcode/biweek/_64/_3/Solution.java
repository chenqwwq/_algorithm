package top.chenqwwq.leetcode.biweek._64._3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author chen
 * @date 2021/10/30
 **/
public class Solution {
	public int[] platesBetweenCandles(String s, int[][] queries) {
		final int n = s.length();
		List<Integer> idxs = new ArrayList<>();
		TreeMap<Integer, Integer> hash = new TreeMap<>();
		int cnt = 0;
		List<Integer> presum = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == '|') {
				hash.put(i, cnt);
				if (cnt == 0) {
					presum.add(0);
				} else {
					presum.add(presum.get(presum.size() - 1) + i - idxs.get(cnt - 1) - 1);
				}
				idxs.add(i);
				cnt++;
			}
		}

		final int m = queries.length;
		int[] ans = new int[m];
		for (int i = 0; i < m; i++) {
			final int[] query = queries[i];
			final Map.Entry<Integer, Integer> entry = hash.ceilingEntry(query[0]);
			if (entry == null) {
				ans[i] = 0;
				continue;
			}
			final Map.Entry<Integer, Integer> entry1 = hash.floorEntry(query[1]);
			if (entry1 == null || entry1.getKey() <= entry.getKey()) {
				ans[i] = 0;
				continue;
			}


			ans[i] = presum.get(entry1.getValue()) - presum.get(entry.getValue());
		}
		return ans;
	}

	public static void main(String[] args) {
		new Solution().platesBetweenCandles("***|**|*****|**||**|*", new int[][]{
				{4, 5}
		});
	}
}