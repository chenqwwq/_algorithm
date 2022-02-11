package top.chenqwwq.leetcode.daily._20210609;

/**
 * 879. 盈利计划
 * 集团里有 n 名员工，他们可以完成各种各样的工作创造利润。
 * <p>
 * 第 i 种工作会产生 profit[i] 的利润，它要求 group[i] 名成员共同参与。如果成员参与了其中一项工作，就不能参与另一项工作。
 * <p>
 * 工作的任何至少产生 minProfit 利润的子集称为 盈利计划 。并且工作的成员总数最多为 n 。
 * <p>
 * 有多少种计划可以选择？因为答案很大，所以 返回结果模 10^9 + 7 的值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 5, minProfit = 3, group = [2,2], profit = [2,3]
 * 输出：2
 * 解释：至少产生 3 的利润，该集团可以完成工作 0 和工作 1 ，或仅完成工作 1 。
 * 总的来说，有两种计划。
 * 示例 2：
 * <p>
 * 输入：n = 10, minProfit = 5, group = [2,3,5], profit = [6,7,8]
 * 输出：7
 * 解释：至少产生 5 的利润，只要完成其中一种工作就行，所以该集团可以完成任何工作。
 * 有 7 种可能的计划：(0)，(1)，(2)，(0,1)，(0,2)，(1,2)，以及 (0,1,2) 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 100
 * 0 <= minProfit <= 100
 * 1 <= group.length <= 100
 * 1 <= group[i] <= 100
 * profit.length == group.length
 * 0 <= profit[i] <= 100
 *
 * @author chen
 * @date 2021-06-09
 **/
public class Solution {

	private static final int MOD = 1000000007;

	public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
		// 空间优化
		final int m = group.length;
		// dp[i][j] 标识使用员工数和利润
		int[][] dp = new int[n + 1][minProfit + 1];
		for (int i = 0; i <= n; i++) {
			dp[i][0] = 1;
		}

		// 遍历逻辑还是一致,从第一个任务开始遍历
		for (int i = 1; i <= m; i++) {
			int uc = group[i - 1], p = profit[i - 1];
			for (int j = n; j >= uc; --j) {
				// 人数足够完成任务
				// 判断相关利润 -> 之前任务能达到目前的利润或者加上当前任务才能达到这个利润
				for (int pro = 0; pro <= minProfit; pro++) {
					// pro-p 可能为0
					dp[j][pro] = (dp[j][pro] + dp[j - uc][Math.max(0, pro - p)]) % MOD;
				}
			}
		}

		return dp[n][minProfit];
	}
}
//	public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
//		// 工作数
//		final int m = group.length;
//		// 双重限制的01背包
//		// dp[m][n][p] 标识前m个任务，选择n个员工，利润最小为p的种类
//		int[][][] dp = new int[m + 1][n + 1][minProfit + 1];
//		for (int i = 0;i <= n;i++) {
//			dp[0][i][0] = 1;
//		}
//
//		for (int i = 1; i <= m; i++) {
//			int uc = group[i - 1], p = profit[i - 1];
//			for (int j = 0; j <= n; j++) {
//				if (uc > j) {
//					// 人数不足以完成当前的任务,所以直接等于之前的
//					System.arraycopy(dp[i - 1][j], 0, dp[i][j], 0, minProfit + 1);
//				} else {
//					// 人数足够完成任务
//					// 判断相关利润 -> 之前任务能达到目前的利润或者加上当前任务才能达到这个利润
//					for (int pro = 0; pro <= minProfit; pro++) {
//						// pro-p 可能为0
//						dp[i][j][pro] = (dp[i - 1][j][pro] + dp[i - 1][j - uc][Math.max(0, pro - p)]) % MOD;
//					}
//				}
//			}
//		}
//		return dp[m][n][minProfit];
//	}
