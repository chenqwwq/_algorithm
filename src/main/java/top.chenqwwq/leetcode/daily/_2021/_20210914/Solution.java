package top.chenqwwq.leetcode.daily._2021._20210914;

import java.util.List;

/**
 * @author chen
 * @date 2021-09-14
 **/
public class Solution {
	public String findLongestWord(String s, List<String> dictionary) {
		final int n = s.length(), m = dictionary.size();
		int[] dis = new int[m];
		for (int i = 0; i < n; i++) {
			final char c = s.charAt(i);
			for (int j = 0; j < m; j++) {
				if (dis[j] >= dictionary.get(j).length()) {
					continue;
				}
				if (dictionary.get(j).charAt(dis[j]) == c) {
					dis[j]++;
				}
			}
		}

		String ans = "";
		for (int i = 0; i < m; i++) {
			if (dis[i] != dictionary.get(i).length()) {
				continue;
			}
			if (dis[i] > ans.length()) {
				ans = dictionary.get(i);
			} else if (dis[i] == ans.length()) {
				ans = ans.compareTo(dictionary.get(i)) > 0 ? ans : dictionary.get(i);
			}
		}
		return ans;
	}
}