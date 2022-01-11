package top.chenqwwq.leetcode.daily._20210712;

/**
 * @author chen
 * @date 2021/7/12
 **/
public class Solution {
	public int hIndex(int[] citations) {
		final int n = citations.length;
		int ans = 0;
		for (int i = n - 1; i >= 0; i--) {
			if (citations[i] < n - i) {
				break;
			}
			ans = Math.max(n - i, ans);
		}
		return ans;
	}
}