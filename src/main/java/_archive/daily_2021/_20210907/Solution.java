package top.chenqwwq.leetcode.daily._2021._20210907;

/**
 * @author chen
 * @date 2021/9/7
 **/
public class Solution {
	public int balancedStringSplit(String s) {
		int score = 0, ans = 0;
		for (int i = 0; i < s.length(); i++) {
			if ((score += (s.charAt(i) == 'L' ? 1 : -1)) == 0) {
				ans++;
			}
		}
		return ans;
	}
}