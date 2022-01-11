package top.chenqwwq.leetcode.daily._20211124;

/**
 * 字母	数字
 * e	0 1 3 5 7 8 9
 * f	4 5
 * g	8
 * h	3 8
 * i	5 6 8 9
 * n	1 7 9
 * o	0 1 2 4
 * r	0 3 4
 * s	6 7
 * t	2 3 8
 * u	4
 * v	5 7
 * w	2
 * x	6
 * z	0
 * <p>
 *
 * @author chen
 * @date 2021-11-24
 **/
public class Solution {
	String[] nums = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
	int[] hash = new int[26], cnt = new int[10];

	public String originalDigits(String s) {
		final int n = s.length();
		for (int i = 0; i < n; i++) {
			hash[s.charAt(i) - 'a']++;
		}
		cnt[0] = hash['z' - 'a'];
		desc(nums[0], cnt[0]);
		cnt[2] = hash['w' - 'a'];
		desc(nums[2], cnt[2]);
		cnt[4] = hash['u' - 'a'];
		desc(nums[4], cnt[4]);
		cnt[6] = hash['x' - 'a'];
		desc(nums[6], cnt[6]);
		cnt[8] = hash['g' - 'a'];
		desc(nums[8], cnt[8]);
		cnt[3] = hash['t' - 'a'];
		desc(nums[3], cnt[3]);
		cnt[5] = hash['f' - 'a'];
		desc(nums[5], cnt[5]);
		cnt[7] = hash['v' - 'a'];
		desc(nums[7], cnt[7]);
		cnt[9] = hash['i' - 'a'];
		desc(nums[9], cnt[9]);
		cnt[1] = hash['o' - 'a'];
		desc(nums[1], cnt[1]);

		StringBuilder ans = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			while (--cnt[i] >= 0) {
				ans.append(i);
			}
		}
		return ans.toString();
	}

	public void desc(String s, int cnt) {
		for (char c : s.toCharArray()) {
			hash[c - 'a'] -= cnt;
		}
	}
}