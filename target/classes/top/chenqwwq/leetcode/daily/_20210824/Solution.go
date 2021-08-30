package main

/**
 * @author chen
 * @date: 2021/8/24 上午11:01
 * @description:
 *
 */

func findCheapestPrice(n int, flights [][]int, src int, dst int, k int) int {
	const INF = 0x3f3f3f3f
	fill := func(nums []int, num int) {
		for i := range nums {
			nums[i] = num
		}
	}
	min := func(a, b int) int {
		if a > b {
			return b
		}
		return a
	}

	// 二维 DP
	dp := make([][]int, k+2)
	for i := range dp {
		dp[i] = make([]int, n)
		fill(dp[i], INF)
	}
	dp[0][src] = 0
	for i := 1; i < k+2; i++ {
		for _, v := range flights {
			dp[i][v[1]] = min(dp[i][v[1]], dp[i-1][v[0]]+v[2])
		}
	}
	ans := INF
	for i := 1; i <= k+1; i++ {
		ans = min(ans, dp[i][dst])
	}
	if ans == INF{
		return -1
	}
	return ans
}
