package top.chenqwwq.leetcode.lcof2._85;

/**
 * @author chenbingxin
 * @date 2021/12/6
 **/
public class Solution {
	public int maxProduct(String[] words) {
		// 使用 int 表示是否包含某个字符
		final int n = words.length;
		final int[] hash = new int[n], lens = new int[n];
		for (int i = 0; i < n; i++) {
			lens[i] = words[i].length();
			for (char c : words[i].toCharArray()) {
				hash[i] |= (1 << (c - 'a'));
			}
		}

		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if ((hash[i] & hash[j]) == 0) {
					ans = Math.max(ans, lens[i] * lens[j]);
				}
			}
		}
		return ans;
	}
}