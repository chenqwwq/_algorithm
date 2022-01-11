package top.chenqwwq.leetcode.lcof2._14;

import java.util.Arrays;

/**
 * @author chenbingxin
 * @date 2021/12/10
 **/
public class Solution {
	public boolean checkInclusion(String s1, String s2) {
		// 窗口大小固定的滑动窗口
		final int n = s1.length(), m = s2.length();
		if (m < n) {
			return false;
		}
		final int[] h1 = new int[26],h2 = new int[26];
		for (int i = 0; i < n; i++) {
			h1[s1.charAt(i) - 'a']++;
			h2[s2.charAt(i) - 'a']++;
		}
		for (int i = n;i < m;i++){
			if (Arrays.equals(h1,h2)){
				return true;
			}
			h2[s2.charAt(i-n)-'a']--;
			h2[s2.charAt(i)-'a']++;
		}

		return Arrays.equals(h1,h2);
	}
}