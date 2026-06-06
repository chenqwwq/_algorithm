package _518

import (
	"sort"
)

/**
  @user: chenqwwq
  @date: 2020/9/21
*/

/**
518. 零钱兑换 II
给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。

示例 1:
输入: amount = 5, coins = [1, 2, 5]
输出: 4
解释: 有四种方式可以凑成总金额:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1

示例 2:
输入: amount = 3, coins = [2]
输出: 0
解释: 只用面额2的硬币不能凑成总金额3。
示例 3:

输入: amount = 10, coins = [10]
输出: 1

注意:
你可以假设：
0 <= amount (总金额) <= 5000
1 <= coin (硬币面额) <= 5000
硬币种类不超过 500 种
结果符合 32 位符号整数
*/

func change(amount int, coins []int) int {
	if amount == 0{
		return 0
	}
	// 硬币的种类
	n := len(coins)

	// dp[i][j]表示前i中硬币组合成j块钱的方式
	dp := make([][]int, n)
	for i := 0; i < n; i++ {
		dp[i] = make([]int, amount+1)
	}

	sort.Ints(coins)

	// 初始化
	for i := 0; i <= amount; i++ {
		// 是否可以凑出来
		if i%coins[0] == 0 {
			dp[0][i] = 1
		} else {
			dp[0][i] = 0
		}
	}

	// 前i种硬币
	for i := 1; i < n; i++ {
		// 多少价值
		for j := 0; j <= amount; j++ {
			// 几个硬币
			for k := 0; k*coins[i] <= j; k++ {
				dp[i][j] += dp[i-1][j-k*coins[i]]
			}
		}
	}

	return dp[n-1][amount]
}
