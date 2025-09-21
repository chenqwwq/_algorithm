package top.chenqwwq.leetcode.daily._2021._20210919;

/**
 * @author chen
 * @date 2021/9/19
 **/
public class Solution {
	public int minSteps(int n) {
		if (n == 1) {
			return 0;
		}

		// dp[i][j] 表示记事本为i，粘贴板为j的时候的操作数
		int[][] dp = new int[n + 1][n + 1];

		// 初始化
		dp[1][0] = 0;
		dp[1][1] = 1;

		// 迭代
		for (int i = 2; i <= n; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = i - 1; j >= 1; --j) {
				if (dp[i - j][j] == 0) {
					continue;
				}
				dp[i][j] = dp[i - j][j] + 1;
				min = Math.min(dp[i][j], min);
			}
			dp[i][i] = min + 1;
		}

		return dp[n][n] - 1;
	}


}