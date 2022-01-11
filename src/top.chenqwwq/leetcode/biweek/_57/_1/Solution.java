package top.chenqwwq.leetcode.biweek._57._1;

/**
 * @author chen
 * @date 2021/7/24
 **/
public class Solution {
	public boolean areOccurrencesEqual(String s) {
		int[] hash = new int[26];
		for (char c : s.toCharArray()) {
			hash[c - 'a']++;
		}
		int target = -1;
		for (int cnt : hash) {
			if (cnt != 0) {
				if (target == -1) {
					target = cnt;
					continue;
				}
				if (target != cnt) {
					return false;
				}
			}
		}
		return true;
	}
}