package top.chenqwwq.leetcode.week._253._3;

/**
 * @author chen
 * @date 2021/8/8
 **/
public class Solution {
	public int minSwaps(String s) {
		final int n = s.length();
		int left = 0, right = n - 1;
		int ans = 0;
		final char[] sc = s.toCharArray();
		while (left < right) {
			// 找到第一个不匹配的
			int cnt = 0;
			for (int i = left; i < right; i++) {
				if (sc[i] == ']') {
					if (--cnt == -1) {
						left = i;
						break;
					}
				} else {
					cnt++;
				}
			}
			if (cnt != -1) {
				return ans;
			}

			cnt = 0;
			for (int i = right; i > left; --i) {
				if (sc[i] == ']') {
					cnt++;
				} else {
					if (--cnt == -1) {
						right = i;
						break;
					}
				}
			}

			ans++;
			sc[left] = '[';
			sc[right] = ']';

		}
		return ans;
	}

	public static void main(String[] args) {
		new Solution().minSwaps("]]][[[");
	}
}