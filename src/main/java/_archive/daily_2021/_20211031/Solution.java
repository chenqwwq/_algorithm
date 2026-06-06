package top.chenqwwq.leetcode.daily._2021._20211031;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chen
 * @date 2021/10/31
 **/
public class Solution {
	String[] keyboard = new String[]{"qwertyuiop", "asdfghjkl", "zxcvbnm"};

	int[] hash = new int[26];

	{
		for (int i = 0; i < 3; i++) {
			for (char c : keyboard[i].toCharArray()) {
				hash[c - 'a'] = i;
			}
		}
	}

	public String[] findWords(String[] words) {
		final List<String> ans = new ArrayList<>();
		for (String word : words) {
			if (check(word)) {
				ans.add(word);
			}
		}
		final int n = ans.size();
		String[] res = new String[n];
		for (int i = 0; i < n; i++) {
			res[i] = ans.get(i);
		}
		return res;
	}

	private boolean check(String s) {
		s = s.toLowerCase();
		int target = hash[s.charAt(0) - 'a'];
		for (char c : s.toCharArray()) {
			if (hash[c - 'a'] != target) {
				return false;
			}
		}
		return true;
	}
}