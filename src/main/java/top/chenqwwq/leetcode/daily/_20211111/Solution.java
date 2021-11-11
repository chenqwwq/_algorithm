package top.chenqwwq.leetcode.daily._20211111;

/**
 * 示例 1:
 * <p>
 * 输入: n = 3, k = 0
 * 输出: 1
 * 解释:
 * 只有数组 [1,2,3] 包含了从1到3的整数并且正好拥有 0 个逆序对。
 * 示例 2:
 * <p>
 * 输入: n = 3, k = 1
 * 输出: 2
 * 解释:
 * 数组 [1,3,2] 和 [2,1,3] 都有 1 个逆序对。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/k-inverse-pairs-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chen
 * @date 2021-11-11
 **/
public class Solution {
	private static final int MOD = (int) (1e9 + 7);

	public int kInversePairs(int n, int k) {
		// 表示1 ~ n 的数组 k 个逆序对的情况
		int[][] dp = new int[n + 1][k + 1];

		// 没有逆序对的情况都只有一种
		for (int i = 1; i <= n; i++) {
			dp[i][0] = 1;
		}

		// 从小开始枚举最大值
		for (int i = 2; i <= n; i++) {
			// 枚举逆序对数目
			// 从 1 ~ i 需要 j 个逆序对
			for (int j = 1; j <= k; j++) {
				dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD;
				if (i <= j) {
					dp[i][j] = (dp[i][j] - dp[i - 1][j - i] + MOD) % MOD;

				}
			}
		}

		return dp[n][k];
	}
}