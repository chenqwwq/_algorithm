package top.chenqwwq.leetcode.contest.weekly._251._2;

/**
 * @author chen
 * @date 2021/7/25
 **/
public class Solution {
	public String maximumNumber(String num, int[] change) {
		int[] up = new int[10];
		for (int i = 0; i < 10; i++) {
			up[i] = Integer.compare(change[i], i);
		}

		final int n = num.length();
		StringBuilder ans = new StringBuilder();
		for (int i = 0; i < n; i++) {
			if (up[num.charAt(i) - '0'] <= 0) {
				ans.append(num.charAt(i));
			} else {
				while (i < n && up[num.charAt(i) - '0'] >= 0) {
					ans.append(change[num.charAt(i++) - '0']);
				}
				ans.append(num.substring(i));
				return ans.toString();
			}
		}
		return num;
	}
}