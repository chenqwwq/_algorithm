package top.chenqwwq.leetcode.contest.weekly._263._1;

/**
 * @author chen
 * @date 2021-10-18
 **/
public class Solution {
	public boolean areNumbersAscending(String s) {
		final String[] split = s.split(" ");
		int curr = 0;
		for (String num : split) {
			Integer v = valueOf(num);
			if (v == -1) {
				continue;
			}
			if (curr < v) {
				curr = v;
			} else {
				return false;
			}
		}
		return true;
	}

	public Integer valueOf(String val) {
		try {
			return Integer.valueOf(val);
		} catch (Exception e) {
			return -1;
		}
	}
}