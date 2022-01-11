package top.chenqwwq.leetcode.daily._20210622;

import lombok.val;

import java.util.ArrayList;
import java.util.Arrays;
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
 * 1 <= s 的长度 <= 8
 *
 * @author chen
 * @date 2021-06-22
 **/
public class Solution {

	List<String> ans = new ArrayList<>();

	public String[] permutation(String s) {
		val chars = s.toCharArray();
		Arrays.sort(chars);
		dfs(chars, "", new boolean[8]);
		return ans.toArray(new String[0]);
	}

	public void dfs(char[] s, String cur, boolean[] used) {
		if (cur.length() == s.length) {
			ans.add(cur);
			return;
		}

		// 同一层不能使用相同的字符
		for (int i = 0; i < s.length; i++) {
			if (used[i] || (i > 0 && used[i-1] && s[i] == s[i - 1])) {
				continue;
			}
			used[i] = true;
			dfs(s, cur + s[i], used);
			used[i] = false;
		}
	}
}