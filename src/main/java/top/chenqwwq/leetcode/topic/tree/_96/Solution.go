package _96

/**
96. 不同的二叉搜索树
给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？

示例:

输入: 3
输出: 5
解释:
给定 n = 3, 一共有 5 种不同结构的二叉搜索树:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
*/

func numTrees(n int) int {
	// 动态规划

	// dp[i] = sum(dp[1]*dp[i-1] + dp[2]*d[i-2] + ... + dp[i-1][1])
	dp := make([]int, n+1)
	dp[0] = 1
	dp[1] = 1

	for i := 2; i <= n; i++ {
		t := 0
		for j := 1; j <= i; j++ {
			t += dp[j-1] * dp[i-j]
		}
		dp[i] = t
	}

	return dp[n]

}
