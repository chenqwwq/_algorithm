package top.chenqwwq.leetcode.daily._20211008;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chen
 * @date 2021-10-08
 **/
public class Solution {
	public List<String> findRepeatedDnaSequences(String s) {
		final int n = s.length();
		Map<String, Integer> hash = new HashMap();
		int left = 0, right = 10;
		List<String> ans = new ArrayList<>();
		while (right <= n) {
			final String word = s.substring(left, right);
			int cnt = hash.getOrDefault(word, 0);
			if (cnt == 1) {
				ans.add(word);
			}
			hash.put(word, cnt + 1);
			left++;
			right++;

		}
		return ans;
	}
}