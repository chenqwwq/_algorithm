package top.chenqwwq.leetcode.daily._20210901;

/**
 * @author chen
 * @date 2021-09-01
 **/
public class Solution {
	public int compareVersion(String version1, String version2) {
		final String[] v1 = version1.split("\\."), v2 = version2.split("\\.");
		int n = Math.max(v1.length, v2.length);
		for (int i = 0; i < n; i++) {
			final int n1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
			final int n2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;
			if (n1 > n2) {
				return 1;
			}
			if (n1 < n2) {
				return -1;
			}
		}
		return 0;
	}
}