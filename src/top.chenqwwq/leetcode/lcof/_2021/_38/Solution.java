package top.chenqwwq.leetcode.lcof._2021._38;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 38. 字符串的排列
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * <p>
 * <p>
 * <p>
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 * <p>
 * <p>
 * 限制：
 * <p>
 * 1 <= s 的长度 <= 8
 *
 * @author chen
 * @date 2021-07-14
 **/
public class Solution {
	List<String> ans = new ArrayList<>();

	public String[] permutation(String s) {
		final int n = s.length();
		backtracking(s, new boolean[n], new char[n], 0);
		return ans.toArray(ans.toArray(new String[0]));
	}

	public void backtracking(String s, boolean[] visit, char[] chars, int cnt) {
		if (cnt == s.length()) {
			ans.add(new String(chars));
			return;
		}
		boolean[] has = new boolean[26];
		for (int i = 0; i < s.length(); i++) {
			if (visit[i] || has[s.charAt(i) - 'a']) {
				continue;
			}
			visit[i] = true;
			chars[cnt] = s.charAt(i);
			has[s.charAt(i) - 'a'] =  true;
			backtracking(s, visit, chars, cnt + 1);
			visit[i] = false;
		}
	}
}