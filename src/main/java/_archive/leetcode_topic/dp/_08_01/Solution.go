package _08_01

/**
  @user: chenqwwq
  @date: 2020/8/11
*/

/**
面试题 08.01. 三步问题
三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。

*/

const MOD = 1000000007

//func waysToStep(n int) int {
//	if n == 1 {
//		return 1
//	}
//	if n == 2 {
//		return 2
//	}
//	if n == 3 {
//		return 4
//	}
//
//	return (waysToStep(n-1) + waysToStep(n-2) + waysToStep(n-3)) % MOD
//}
func waysToStep(n int) int {
	// 范围在0~1000000递归铁超时

	dp := make([]int, 3)

	dp[0], dp[1], dp[2] = 1, 2, 4

	if n <= 3 {
		return dp[n-1]
	}

	for i := 4; i <= n; i++ {
		dp[0], dp[1], dp[2] = dp[1], dp[2], (dp[0]+dp[1]+dp[2])%MOD
	}

	return dp[2]
}
