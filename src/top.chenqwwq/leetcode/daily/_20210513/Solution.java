package top.chenqwwq.leetcode.daily._20210513;

/**
 * 1269. 停在原地的方案数
 * 有一个长度为 arrLen 的数组，开始有一个指针在索引 0 处。
 * <p>
 * 每一步操作中，你可以将指针向左或向右移动 1 步，或者停在原地（指针不能被移动到数组范围外）。
 * <p>
 * 给你两个整数 steps 和 arrLen ，请你计算并返回：在恰好执行 steps 次操作以后，指针仍然指向索引 0 处的方案数。
 * <p>
 * 由于答案可能会很大，请返回方案数 模 10^9 + 7 后的结果。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：steps = 3, arrLen = 2
 * 输出：4
 * 解释：3 步后，总共有 4 种不同的方法可以停在索引 0 处。
 * 向右，向左，不动
 * 不动，向右，向左
 * 向右，不动，向左
 * 不动，不动，不动
 * 示例  2：
 * <p>
 * 输入：steps = 2, arrLen = 4
 * 输出：2
 * 解释：2 步后，总共有 2 种不同的方法可以停在索引 0 处。
 * 向右，向左
 * 不动，不动
 * 示例 3：
 * <p>
 * 输入：steps = 4, arrLen = 2
 * 输出：8
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= steps <= 500
 * 1 <= arrLen <= 10^6
 *
 * @author chen
 * @date 2021-05-13
 **/
public class Solution {

	private static final int MOD = 1000000007;

	public int numWays(int steps, int arrLen) {
		// arrLen 的范围算是迷惑值吗

		// 最远距离
		int maxLen = Math.min(steps, arrLen);
		// dp[i][j] 表示第i+1次在j下标的不同方法数
		long[][] dp = new long[steps][maxLen];
		dp[0][0] = 1;
		dp[0][1] = 1;

		for (int i = 1; i < steps; i++) {
			// 当前步骤最远能到达
			final int maxReach = Math.min(maxLen, i + 2);
			for (int j = 0; j < maxReach; j++) {
				// 原地不动的情况
				long a = dp[i - 1][j];
				// 右移的情况
				long b = j - 1 >= 0 ? dp[i - 1][j - 1] : 0;
				// 左移的情况
				long c = j + 1 < maxReach ? dp[i - 1][j + 1] : 0;
				dp[i][j] = (a + b + c) % MOD;
			}
		}

		return (int) (dp[steps - 1][0] % MOD);
	}
}


































