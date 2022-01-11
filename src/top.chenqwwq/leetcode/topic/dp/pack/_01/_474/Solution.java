package top.chenqwwq.leetcode.topic.dp.pack._01._474;

/**
 * @author chen
 * @date 2021/9/11
 **/
public class Solution {

	private int[] getCnt(String str) {
		int[] ans = new int[2];
		for (int i = 0; i < str.length(); i++) {
			ans[str.charAt(i) - '0']++;
		}
		return ans;
	}

	public int findMaxForm(String[] strs, int m, int n) {
		final int len = strs.length;
		int[][] cnts = new int[len][2];
		for (int i = 0; i < len; i++) {
			cnts[i] = getCnt(strs[i]);
		}

		// m 表示0的数量 n表示1的数量
		int[][] dp = new int[m + 1][n + 1];
		for (int i = 0; i < len; i++) {
			for (int c0 = m; c0 >= cnts[i][0]; --c0) {
				for (int c1 = n; c1 >= cnts[i][1]; --c1) {
					dp[c0][c1] = Math.max(dp[c0][c1], dp[c0 - cnts[i][0]][c1 - cnts[i][1]] + 1);
				}
			}
		}
		return dp[m][n];
	}
}
