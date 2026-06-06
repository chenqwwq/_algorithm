package top.chenqwwq.leetcode.contest.weekly._245._1;

/**
 * @author chen
 * @date 2021/6/13
 **/
public class Solution {
	public boolean makeEqual(String[] words) {
		int[] hash = new int[26];
		for (String str : words) {
			for (char c : str.toCharArray()) {
				hash[c - 'a']++;
			}
		}
		final int cnt = words.length;
		for (int num : hash) {
			if (num == 0) {
				continue;
			}
			if (num % cnt != 0) {
				return false;
			}
		}
		return true;
	}
}