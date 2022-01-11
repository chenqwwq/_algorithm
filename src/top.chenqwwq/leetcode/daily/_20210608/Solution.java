package top.chenqwwq.leetcode.daily._20210608;

/**
 * 1049. 最后一块石头的重量 II
 * 有一堆石头，用整数数组 stones 表示。其中 stones[i] 表示第 i 块石头的重量。
 * <p>
 * 每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 * <p>
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：stones = [2,7,4,1,8,1]
 * 输出：1
 * 解释：
 * 组合 2 和 4，得到 2，所以数组转化为 [2,7,1,8,1]，
 * 组合 7 和 8，得到 1，所以数组转化为 [2,1,1,1]，
 * 组合 2 和 1，得到 1，所以数组转化为 [1,1,1]，
 * 组合 1 和 1，得到 0，所以数组转化为 [1]，这就是最优值。
 * 示例 2：
 * <p>
 * 输入：stones = [31,26,33,21,40]
 * 输出：5
 * 示例 3：
 * <p>
 * 输入：stones = [1,2]
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 100
 *
 * @author chen
 * @date 2021/6/8
 **/
public class Solution {


	public int lastStoneWeightII(int[] stones) {
		final int n = stones.length;
		if (n == 1) {
			return stones[0];
		}
		if (n == 2) {
			return Math.abs(stones[0] - stones[1]);
		}

		int sum = 0;
		for (int stone : stones) {
			sum += stone;
		}
		int target = sum >> 1;
		boolean[] dp = new boolean[target + 1];
		dp[0] = true;
		for (int stone : stones) {
			for (int w = target; w >= 0; w--) {
				// dp[i][w] 表示前i个数字是否可以凑出w
				if (w >= stone) {
					dp[w] = dp[w] || dp[w - stone];
				}
			}
		}

		for (int i = target; i >= 0; i--) {
			if (dp[i]) {
				return sum - 2 * i;
			}
		}

		return -1;
	}

//	public int lastStoneWeightII(int[] stones) {
//		final int n = stones.length;
//		if (n == 1) {
//			return stones[0];
//		}
//		if (n == 2) {
//			return Math.abs(stones[0] - stones[1]);
//		}
//
//		// 题目化简为0，1背包问题
//
//		int[] sum = new int[n];
//		sum[0] = stones[0];
//		for (int i = 1; i < n; i++) {
//			sum[i] = stones[i] + sum[i - 1];
//		}
//
//		// dp[i][j] 表示前i个数字组成j的可能性
//		int max = sum[n - 1];
//		int target = max >> 1;
//		boolean[][] dp = new boolean[n + 1][target + 1];
//		dp[0][0] = true;
//
//		for (int i = 0; i < n; i++) {
//			for (int w = 0; w <= target; w++) {
//				// dp[i][w] 表示前i个数字是否可以凑出w
//				if (w < stones[i]) {
//					dp[i + 1][w] = dp[i][w];
//				} else {
//					dp[i + 1][w] = dp[i][w] || dp[i][w - stones[i]];
//				}
//			}
//		}
//
//		for (int i = target; i >= 0; i--) {
//			if (dp[n][i]) {
//				return max - 2 * i;
//			}
//		}
//
//		return -1;
//	}

//	public int lastStoneWeightII(int[] stones) {
//		return dfs(stones, 0, 0);
//	}
//
//	public int dfs(int[] stones, int curr, int weight) {
//		if (curr == stones.length) {
//			if (weight >= 0) {
//				return weight;
//			}
//			return Integer.MAX_VALUE;
//		}
//
//		return Math.min(dfs(stones, curr + 1, weight + stones[curr]), dfs(stones, curr + 1, weight - stones[curr]));
//	}
}