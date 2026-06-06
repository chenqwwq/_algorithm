package top.chenqwwq.leetcode.contest.weekly._243._2;

/**
 * @author chen
 * @date 2021/5/30
 **/
public class Solution {
	public String maxValue(String n, int x) {
		int idx = 0;
		if (n.charAt(0) == '-') {
			for (int i = 0; i < n.length(); i++) {
				idx = n.length();
				if (n.charAt(i) - '0' > x) {
					idx = i;
					break;
				}
			}
		} else {
			// 从前往后找一个比x小的数字
			idx = n.length();
			for (int i = 0; i < n.length(); i++) {
				if (n.charAt(i) - '0' < x) {
					idx = i;
					break;
				}
			}

		}

		return n.substring(0, idx) + x + n.substring(idx);
	}
}