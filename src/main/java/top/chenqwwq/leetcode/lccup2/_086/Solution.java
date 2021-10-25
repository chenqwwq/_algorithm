package top.chenqwwq.leetcode.lccup2._086;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chen
 * @date 2021/10/24
 **/
public class Solution {
	List<List<String>> ans = new ArrayList<>();
	String s;
	int n;

	public String[][] partition(String _s) {
		s = _s;
		n = s.length();
		backtrace(new ArrayList<>(), 0);
		return wrap(ans);
	}

	public String[][] wrap(List<List<String>> res) {
		final int n = res.size();
		final String[][] ans = new String[n][];
		for (int i = 0; i < n; i++) {
			final List<String> tmp = res.get(i);
			final int k = tmp.size();
			ans[i] = new String[k];
			for (int q = 0; q < k; q++) {
				ans[i][q] = tmp.get(q);
			}
		}
		return ans;
	}

	public void backtrace(List<String> curr, int idx) {
		if (idx == n) {
			ans.add(new ArrayList<>(curr));
			return;
		}

		for (int i = 0; idx + i < n; i++) {
			if (!isPalindrome(idx, idx + i)) {
				continue;
			}
			curr.add(s.substring(idx, idx + i + 1));
			backtrace(curr, idx + i + 1);
			curr.remove(curr.size() - 1);
		}
	}

	public boolean isPalindrome(int i, int j) {
		if (i == j) {
			return true;
		}
		while (i < j) {
			if (s.charAt(i++) != s.charAt(j--)) {
				return false;
			}
		}
		return true;
	}
}