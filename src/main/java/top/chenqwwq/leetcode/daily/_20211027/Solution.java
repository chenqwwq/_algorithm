package top.chenqwwq.leetcode.daily._20211027;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author chen
 * @date 2021-10-27
 **/
public class Solution {
	Set<String> ans = new HashSet<>();
	String s;
	int n, len, mc;

	public List<String> removeInvalidParentheses(String _s) {
		s = _s;
		n = _s.length();
		int l = 0, r = 0, c = 0;
		for (char ch : _s.toCharArray()) {
			if (ch == '(') {
				l++;
			} else if (ch == ')') {
				r++;
			}
		}
		mc = Math.min(l, r);
		dfs(0, "", 0);
		return new ArrayList<>(ans);
	}

	public void dfs(int idx, String curr, int score) {
		if (score < 0 || score > mc) {
			return;
		}

		if (idx == n) {
			if (score == 0) {
				if (curr.length() < len) {
					return;
				}
				if (curr.length() > len) {
					ans.clear();
					len = curr.length();
				}
				ans.add(curr);
			}
			return;
		}

		final char c = s.charAt(idx);
		if (c == ')') {
			dfs(idx + 1, curr + c, score - 1);
			dfs(idx + 1, curr, score);
		} else if (c == '(') {
			dfs(idx + 1, curr + c, score + 1);
			dfs(idx + 1, curr, score);
		} else {
			dfs(idx + 1, curr + c, score);
		}
	}
}