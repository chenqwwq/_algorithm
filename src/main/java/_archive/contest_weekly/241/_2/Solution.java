package top.chenqwwq.leetcode.contest.weekly._241._2;

/**
 * @author chen
 * @date 2021/5/16
 **/
public class Solution {
	public int minSwaps(String s) {
		final char[] chars = s.toCharArray();
		int[] cnt = new int[2];
		for (int i = 0; i < s.length(); i++) {
			cnt[chars[i] - '0']++;
		}
		final int abs = Math.abs(cnt[0] - cnt[1]);
		if (abs > 1) {
			return -1;
		}

		if (abs == 1) {
			char mode = cnt[0] > cnt[1] ? '0' : '1';
			int ans = 0;
			for (int i = 0; i < s.length(); i += 2) {
				if (mode != chars[i]) {
					ans++;
				}
			}
			return ans;
		}

		int ans = Integer.MAX_VALUE;
		for (char mode = '0'; mode < '2'; mode++) {
			int t = 0;
			for (int i = 0; i < s.length(); i += 2) {
				if (mode != chars[i]) {
					t++;
				}
			}
			ans = Math.min(ans, t);
		}
		return ans;
	}

}