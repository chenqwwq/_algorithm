package top.chenqwwq.leetcode.contest.weekly._244._3;

/**
 * @author chen
 * @date 2021/6/6
 **/
public class Solution {
	public int minFlips(String s) {
		int n = s.length();
		int[] pre = new int[s.length()];
		pre[0] = s.charAt(0) - '0';
		for (int i = 1; i < n; i++) {
			pre[i] = pre[i - 1] + (s.charAt(i) - '0') ^ (i & 1);
		}
		int ans = n;
		for (int i = 0; i < n; i++) {
			int f = (i & 1) ^ ((n - i) & 1);
			int L = i > 0 ? pre[i - 1] : 0;
			int R = pre[n - 1] - L;
			int pans = f > 0 ? L + (n - i - R) : L + R;
			ans = Math.min(ans, Math.min(pans, n - pans));
		}
		return ans;
	}
}