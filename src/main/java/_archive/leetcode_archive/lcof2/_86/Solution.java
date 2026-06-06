package top.chenqwwq.leetcode.archive.lcof2._86;


import java.util.ArrayList;
import java.util.List;

/**
 * @author chenbingxin
 * @date 2021/12/7
 **/
public class Solution {
	public String[][] partition(String s) {
		preAns = new ArrayList<>();
		backtrace(s, 0, new ArrayList<>());

		final int n = preAns.size();
		final String[][] ans = new String[n][];
		for (int i = 0; i < n; i++) {
			final List<String> arr = preAns.get(i);
			ans[i] = arr.toArray(new String[0]);
		}
		return ans;
	}

	List<List<String>> preAns;

	public void backtrace(String s, int idx, List<String> curr) {
		if (idx >= s.length()) {
			preAns.add(new ArrayList<>(curr));
			return;
		}

		// 从idx开始分割
		for (int i = idx; i < s.length(); i++) {
			if (isPartition(s, idx, i)) {
				curr.add(s.substring(i, idx + 1));
				backtrace(s, i + 1, curr);
				curr.remove(curr.size() - 1);
			}
		}
	}

	public boolean isPartition(String s, int i, int j) {
		while (i < j) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
}