package _3

/**
 * @author chen
 * @date: 2020/9/12 下午10:13
 * @description:
 *
 */

func minimumOperations(leaves string) int {
	l := len(leaves)
	if l < 3 {
		return -1
	}

	// answer
	ans := 0

	// pre handle
	if leaves[0] == 'y' {
		ans++
	}
	if leaves[l-1] == 'y' {
		ans++
	}

	// 开始处理中间数据
	// 因为已经确保两边都有红了，所以中间随便怎么切两刀就好
	// dp[][0] 为全红,只能从全红变过来
	// dp[][1] 红黄,能从红或者红黄变过来
	// dp[][2] 红黄红，从红黄或者红黄红变过来
	var dp [][3]int
	for i := 0; i < l-1; i++ {
		dp = append(dp, [3]int{})
	}
	for i := 1; i < l-1; i++ {
		if leaves[i] == 'y' {
			dp[i][0] = dp[i-1][0] + 1
			dp[i][1] = min(dp[i-1][0], dp[i-1][1])
			if i > 1 {
				dp[i][2] = min(dp[i-1][1], dp[i-1][2]) + 1
			} else {
				dp[i][2] = dp[i][1]
			}
		} else {
			dp[i][0] = dp[i-1][0]
			dp[i][1] = min(dp[i-1][0], dp[i-1][1]) + 1
			if i > 1 {
				dp[i][2] = min(dp[i-1][2], dp[i-1][1])
			} else {
				dp[i][2] = dp[i][1]
			}
		}
	}

	return ans + min(dp[l-2][1], dp[l-2][2])

}

func min(a, b int) int {
	if a > b {
		return b
	}
	return a
}
