package example

/**
  @user: chenqwwq
  @date: 2020/9/21
*/

/**
	01背包
   有 n 个重量和价值分别为Wi,Vi的物品，现从这些物品中挑选出总量不超过 W 的物品，求所有方案中价值总和的最大值。

 	状态转移方程
   dp[i][j] = max{dp[i-1][j],dp[i-1][j-wi[i]]+vi[i]}
*/

// 基础01背包
func _01backpack_basic(n, w int, wi, vi []int) int {

	// dp[i][j] 表示前i个物品，j份重量的价值
	dp := make([][]int, n)
	for i := 0; i < n; i++ {
		dp[i] = make([]int, w+1)
	}

	// init
	for i := 0; i < w; i++ {
		if wi[0] <= i {
			dp[0][i] = vi[0]
		} else {
			dp[0][i] = 0
		}
	}

	// main
	// 针对每件物品
	for i := 1; i < n; i++ {
		// 每份重量
		for j := 0; j <= w; j++ {
			if j >= wi[i] {
				dp[i][j] = max(dp[i-1][j], dp[i-1][j-wi[i]]+vi[i])
			} else {
				dp[i][j] = dp[i-1][j]
			}
		}
	}

	return dp[n-1][w]
}

// 01背包 优化空间复杂度
func _01backpack_lessmemory(n, w int, wi, vi []int) int {

	// dp array
	dp := make([]int, w+1)

	// init
	for i := 0; i <= w; i++ {
		if wi[0] <= i {
			dp[i] = vi[0]
		} else {
			dp[i] = 0
		}
	}

	// main
	for i := 1; i < n; i++ {
		// 优化空间之后为了不让本次的遍历影响结果，需要递减
		for j := w; j >= 0; j-- {
			if j >= wi[i] {
				// 带不带上wi[j]的物品
				dp[j] = max(dp[j], dp[j-wi[i]]+vi[i])
			}
		}
	}

	return dp[w]
}

func max(i, j int) int {
	if i > j {
		return i
	}
	return j
}
