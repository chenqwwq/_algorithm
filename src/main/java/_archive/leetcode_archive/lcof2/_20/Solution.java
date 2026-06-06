package top.chenqwwq.leetcode.archive.lcof2._20;

/**
 * @author chenbingxin
 * @date 2021/12/13
 **/
public class Solution {
	public int countSubstrings(String s) {
		final int n = s.length();
		if (n < 2) {
			return n;
		}

		int ans = 0;
		final boolean[][] dp = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			dp[i][i] = true;
		}
		ans += n;

		for (int i = n - 2; i >= 0; i--) {
			for (int j = i + 1; j < n; j++) {
				char ci = s.charAt(i), cj = s.charAt(j);
				dp[i][j] = ci == cj && (j - i <= 2 || dp[i + 1][j - 1]);
				if(dp[i][j]){
					ans++;
				}
			}
		}
		return ans;
	}
}
