package top.chenqwwq.leetcode.daily._20210610;

/**
 * 518. 零钱兑换 II
 * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: amount = 5, coins = [1, 2, 5]
 * 输出: 4
 * 解释: 有四种方式可以凑成总金额:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * 示例 2:
 * <p>
 * 输入: amount = 3, coins = [2]
 * 输出: 0
 * 解释: 只用面额2的硬币不能凑成总金额3。
 * 示例 3:
 * <p>
 * 输入: amount = 10, coins = [10]
 * 输出: 1
 * <p>
 * <p>
 * 注意:
 * <p>
 * 你可以假设：
 * <p>
 * 0 <= amount (总金额) <= 5000
 * 1 <= coin (硬币面额) <= 5000
 * 硬币种类不超过 500 种
 * 结果符合 32 位符号整数
 *
 * @author chen
 * @date 2021-06-10
 **/
public class Solution {

	// 记忆化递归
//	Map<Integer, Integer> mem = new HashMap<>();
//
//	public int change(int amount, int[] coins) {
//		return dfs(amount, coins, 0);
//	}
//
//	public int dfs(int amount, int[] coins, int idx) {
//		if (amount == 0) {
//			return 1;
//		}
//		if (amount < 0 || idx >= coins.length) {
//			return 0;
//		}
//		final int key = getKey(amount, idx);
//		if (mem.containsKey(key)) {
//			return mem.get(key);
//		}
//		int ans = 0;
//		for (int cnt = 0; cnt * coins[idx] <= amount; cnt++) {
//			ans += dfs(amount - cnt * coins[idx], coins, idx + 1);
//		}
//		mem.put(key, ans);
//		return ans;
//	}
//
//	private int getKey(int amount, int idx) {
//		return amount * 10000 + idx;
//	}

	public int change(int amount, int[] coins) {
		// 排序,如果coins[i] > amount，直接剔除
		int[] dp = new int[amount + 1];
		dp[0] = 1;

		for (int i = 0; i < coins.length && coins[i] <= amount; i++) {
			for (int c = coins[i]; c <= amount; c++) {
				dp[c] += dp[c - coins[i]];
			}
		}

		return dp[amount];
	}

}