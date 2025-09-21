package top.chenqwwq.leetcode.topic.dp.状压._1434;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chen
 * @date 2021/8/29
 **/
public class Solution {
	private static final int mod = (int) 1e9 + 7;

	public int numberWays(List<List<Integer>> hats) {
		// n people,n -> [1,10]
		final int n = hats.size();
		// 选择状态:
		// 帽子的范围1-40,而人的范围是10以内
		// 所以选择人为状态

		// 转换帽子和人的隐射关系
		List<Integer>[] h2p = new ArrayList[41];
		for (int i = 0; i <= 40; i++) {
			h2p[i] = new ArrayList<>();
		}
		// 选择最大的帽子
		for (int i = 0; i < n; i++) {
			final List<Integer> hat = hats.get(i);
			for (int h : hat) {
				h2p[h].add(i);
			}
		}

		// 定义 dp 数组
		final int size = 1 << n;
		int[][] dp = new int[41][size];
		dp[0][0] = 1;
		// 帽子
		for (int i = 1; i <= 40; i++) {
			// 状态
			for (int k = 0; k < size; k++) {
				dp[i][k] = dp[i - 1][k];
				// 人
				for (int p : h2p[i]) {
					// 状态
					if ((k & (1 << p)) != 0) {
						dp[i][k] = (dp[i][k] + dp[i - 1][k ^ (1 << p)]) % mod;
					}
				}
			}
		}

		return dp[40][size - 1];
	}
}