package top.chenqwwq.leetcode.weekly._258._3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chen
 * @date 2021/9/12
 **/
public class Solution {
	Map<Integer, Integer> values = new HashMap<>();
	String s;

	public int maxProduct(String _s) {
		s = _s;
		dfs(0, "", 0);
		final List<Integer> keys = new ArrayList<>(values.keySet());
		int ans = 0;
		for (int i = 0; i < keys.size(); i++) {
			for (int j = i + 1; j < keys.size(); j++) {
				if ((keys.get(i) & keys.get(j)) != 0) {
					continue;
				}
				ans = Math.max(ans, values.get(keys.get(i)) * values.get(keys.get(j)));
			}
		}
		return Math.max(ans, 1);
	}

	public void dfs(int idx, String curr, int state) {
		final int n = curr.length();
		if (n > 0) {
			boolean flag = true;
			for (int i = 0; i < n >> 1; i++) {
				if (curr.charAt(i) != curr.charAt(n - i - 1)) {
					flag = false;
					break;
				}
			}
			if (flag) {
				values.put(state, n);
			}
		}
		if (idx >= s.length()) {
			return;
		}
		dfs(idx + 1, curr, state);
		dfs(idx + 1, curr + s.charAt(idx), state | (1 << idx));
	}
}