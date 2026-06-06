package top.chenqwwq.leetcode.topic.backtrack._131;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. 分割回文串
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * <p>
 * 回文串 是正着读和反着读都一样的字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * 示例 2：
 * <p>
 * 输入：s = "a"
 * 输出：[["a"]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 16
 * s 仅由小写英文字母组成
 *
 * @author chen
 * @date 2021/5/22
 **/
public class Solution {
	List<List<String>> ans = new ArrayList<>();

	public List<List<String>> partition(String s) {
		if (s == null || s.length() == 0) {
			return ans;
		}
		bt(s,0,new ArrayList<>());
		return ans;
	}

	public void bt(String s, int idx, List<String> curr) {
		if (idx == s.length()) {
			ans.add(new ArrayList<>(curr));
			return;
		}

		for (int i = idx + 1; i <= s.length(); i++) {
			if (check(s, idx, i - 1)) {
				curr.add(s.substring(idx, i));
				bt(s, i, curr);
				curr.remove(curr.size() - 1);
			}
		}
	}

	public boolean check(String s, int start, int end) {
		if (start == end) {
			return true;
		}
		while (start < end) {
			if (s.charAt(start++) != s.charAt(end--)) {
				return false;
			}
		}
		return true;
	}
}