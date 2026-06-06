package top.chenqwwq.leetcode.archive.lcof._2021._48;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 48. 最长不含重复字符的子字符串
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * <p>
 * 提示：
 * <p>
 * s.length <= 40000
 *
 * @author chen
 * @date 2021-07-27
 **/
public class Solution {
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		final int n = s.length();
		Map<Character, Integer> hash = new HashMap<>();
		int l = 0, r = -1, ans = 0, curr = 0;
		while (++r < n) {
			final char rc = s.charAt(r);
			final Integer put = hash.put(rc, hash.getOrDefault(rc, 0) + 1);
			curr++;

			if (put == null || put == 0) {
				hash.put(rc, 1);
				ans = Math.max(ans, curr);
			} else {
				while (l < r) {
					final char lc = s.charAt(l);
					l++;
					hash.put(lc, hash.get(lc) - 1);
					curr--;
					if (lc == rc) {
						break;
					}
				}
			}
		}
		return ans;
	}
}