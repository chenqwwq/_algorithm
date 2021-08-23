package _20201228

import "math"

/**
  @user: chenqwwq
  @date: 2020/12/28
*/

/**
188. 买卖股票的最佳时机 IV
给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。
设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

示例 1：
输入：k = 2, prices = [2,4,1]
输出：2
解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
示例 2：
输入：k = 2, prices = [3,2,6,5,0,3]
输出：7
解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
     随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。

提示：
0 <= k <= 109
0 <= prices.length <= 1000
0 <= prices[i] <= 1000
*/

func maxProfit(k int, prices []int) int {
	l := len(prices)
	if l == 0 || k == 0 {
		return 0
	}

	var max func(i, j int) int
	max = func(i, j int) int {
		if i > j {
			return i
		}
		return j
	}

	// dp[0][x][y] 表示x天手上不持有股票且交易了y次的情况
	// dp[1][x][y] 表示x手上持有股票且交易了y次的情况
	var dp [2][][]int
	dp[0] = make([][]int, l)
	dp[1] = make([][]int, l)

	for i := 0; i <= 1; i++ {
		for j := 0; j < l; j++ {
			dp[i][j] = make([]int, k+1)
		}
	}

	dp[0][0][0] = 0
	dp[1][0][0] = -prices[0]

	// 用最大负数表示无效数据
	i2 := math.MinInt64 >> 1
	for i := 1; i <= k; i++ {
		dp[0][0][i] = i2
		dp[1][0][i] = i2
	}

	// 交易天数
	for i := 1; i < len(prices); i++ {

		// 不交易的情况
		// 手上没有股票的情况 = 之前就没有股票
		// 手上持有股票的情况 = 之前就持有股票或者本次买入
		dp[0][i][0], dp[1][i][0] = dp[0][i-1][0], max(dp[1][i-1][0], dp[0][i-1][0]-prices[i])

		// 交易次数
		for cnt := 1; cnt <= k; cnt++ {
			// 手上没有股票的情况 = max(之前就没有股票,有股票但是卖了)
			dp[0][i][cnt] = max(dp[0][i-1][cnt], dp[1][i-1][cnt-1]+prices[i])
			// 手上持有股票的情况 = 之前就持有股票
			dp[1][i][cnt] = max(dp[1][i-1][cnt], dp[0][i-1][cnt]-prices[i])
		}
	}

	ans := 0
	idx := len(prices) - 1
	for i := 0; i <= k; i++ {
		ans = max(ans, dp[0][idx][i])
	}

	return ans
}
