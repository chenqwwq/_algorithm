package _20201217

/**
  @user: chenqwwq
  @date: 2020/12/17
*/

/**
714. 买卖股票的最佳时机含手续费
给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。

你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。

返回获得利润的最大值。

注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。

示例 1:

输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
输出: 8
解释: 能够达到的最大利润:
在此处买入 prices[0] = 1
在此处卖出 prices[3] = 8
在此处买入 prices[4] = 4
在此处卖出 prices[5] = 9
总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
注意:

0 < prices.length <= 50000.
0 < prices[i] < 50000.
0 <= fee < 50000.
*/
func maxProfit(prices []int, fee int) int {
	l := len(prices)
	if l < 2 {
		return 0
	}

	var max func(i, j int) int
	max = func(i, j int) int {
		if i > j {
			return i
		}
		return j
	}

	// dp[0] 表示持有
	// dp[1] 表示不持有
	dp := [2][]int{}

	dp[0] = make([]int, l)
	dp[1] = make([]int, l)

	dp[0][0] = -prices[0]
	dp[0][1] = 0

	for i := 1; i < len(prices); i++ {
		// 持有的情况分两种:
		// 1. 之前没有,现在买入
		// 2. 之前就有，现在不动
		pre := i - 1
		dp[0][i] = max(dp[0][pre], dp[1][pre]-prices[i])

		// 不持有的情况:
		// 1. 之前没有现在不懂
		// 2. 之前有，现在卖了
		dp[1][i] = max(dp[1][pre], dp[0][pre]+prices[i]-fee)
	}

	return dp[1][l-1]

}
