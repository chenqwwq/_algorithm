package top.chenqwwq.leetcode.daily._2021._20211117;

/**
 * @author chen
 * @date 2021-11-17
 **/
public class Solution {
	public int maxProduct(String[] words) {
		final int n = words.length;
		int[] mask = new int[n];
		for (int i = 0; i < n; i++) {
			for (char c : words[i].toCharArray()) {
				mask[i] |= (1 << (c - 'a'));
			}
		}

		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if ((mask[i] & mask[j]) == 0) {
					ans = Math.max(words[i].length() * words[j].length(), ans);
				}
			}
		}
		return ans;
	}
}