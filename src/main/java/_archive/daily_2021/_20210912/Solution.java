package top.chenqwwq.leetcode.daily._2021._20210912;

/**
 * @author chen
 * @date 2021/9/12
 **/
public class Solution {
	public boolean checkValidString(String s) {
		int l = 0, r = 0;
		for (char c : s.toCharArray()) {
			if (c == '(') {
				l++; r++;
			} else if (c == ')') {
				l--; r--;
			} else {
				l--; r++;
			}
			l = Math.max(l, 0);
			if (l > r) return false;
		}
		return l == 0;
	}
}