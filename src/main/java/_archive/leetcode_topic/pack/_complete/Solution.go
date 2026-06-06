package _complete

/**
  @user: chenqwwq
  @date: 2020/9/21
*/

/**
完全背包

有 N 种物品和一个容量为 V 的背包，每种物品都有无限件可用。放入第 i 种物品
的费用是 Ci，价值是 Wi。求解：将哪些物品装入背包，可使这些物品的耗费的费用总
和不超过背包容量，且价值总和最大。
*/

func _complete_backpack_basic(n, w int, wi, vi []int) int {
	dp := make([][]int, n)
	for i := 0; i < n; i++ {
		dp[i] = make([]int, w+1)
	}

	// init
	for i := 0; i <= w; i++ {
		dp[0][i] = i / wi[0]
	}

	// 前i种物品
	for i := 1; i < n; i++ {
		// j份重量
		for j := 0; j <= w; j++ {
			dp[i][j] = dp[i-1][j]
			for k := 1; k*wi[i] <= j; k++ {
				// 当前重量
				wei := k * wi[i]
				dp[i][j] = max(dp[i][j], dp[i-1][j-wei]+k*vi[i])
			}
		}
	}

	return dp[n-1][w]
}

func max(i, j int) int {
	if i > j {
		return i
	}

	return j
}
