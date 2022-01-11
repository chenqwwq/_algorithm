package top.chenqwwq.leetcode.biweek._66._2;

/**
 * @author chenbingxin
 * @date 2021/11/28
 **/
public class Solution {
	public int minimumBuckets(String street) {
		final int n = street.length();

		// 尝试一次遍历解决
		int ans = 0;
		for (int i = 0; i < n; i++) {
			if (street.charAt(i) == 'H') {
				// 先不考虑前置的 .,优先使用后置的
				if (i + 1 < n && street.charAt(i + 1) == '.') {
					// 直接跳过两个
					i += 2;
					ans++;
				} else if (i - 1 >= 0 && street.charAt(i - 1) == '.') {
					ans++;
				} else {
					return -1;
				}
			}
		}
		return ans;
	}
}