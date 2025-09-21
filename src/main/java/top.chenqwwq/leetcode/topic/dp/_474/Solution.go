package _474

/**
  @user: chenqwwq
  @date: 2020/9/29
*/

/**
474. 一和零
在计算机界中，我们总是追求用有限的资源获取最大的收益。
现在，假设你分别支配着 m 个 0 和 n 个 1。另外，还有一个仅包含 0 和 1 字符串的数组。
你的任务是使用给定的 m 个 0 和 n 个 1 ，找到能拼出存在于数组中的字符串的最大数量。每个 0 和 1 至多被使用一次。

示例 1:
输入: strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
输出: 4
解释: 总共 4 个字符串可以通过 5 个 0 和 3 个 1 拼出，即 "10","0001","1","0" 。

示例 2:
输入: strs = ["10", "0", "1"], m = 1, n = 1
输出: 2
解释: 你可以拼出 "10"，但之后就没有剩余数字了。更好的选择是拼出 "0" 和 "1" 。

提示：
1 <= strs.length <= 600
1 <= strs[i].length <= 100
strs[i] 仅由 '0' 和 '1' 组成
1 <= m, n <= 100
*/
func findMaxForm(strs []string, m int, n int) int {
	// 01背包变形
	// 重量变成了0和1的数量，两个维度

	// 取字符串中的01值
	// 低16位表示0的个数，高16位表示1的个数
	a := make([]int, len(strs)+1)
	for idx, v := range strs {
		i, j := 0, 0
		for _, v1 := range v {
			if v1 == '0' {
				j++
			} else {
				i++
			}
		}
		a[idx+1] = i<<16 + j
	}

	// dp[i][j][q] 表示前i个字符,j个0,q个1
	dp := make([][][]int, len(strs)+1)
	for i := 0; i <= len(strs); i++ {
		dp[i] = make([][]int, m+1)
		for j := 0; j <= m; j++ {
			dp[i][j] = make([]int, n+1)
		}
	}

	for i := 1; i <= len(strs); i++ {
		one, zero := a[i]>>16, a[i]&0xFFFF
		for z := 0; z <= m; z++ {
			for o := 0; o <= n; o++ {
				dp[i][z][o] = dp[i-1][z][o]
				if o >= one && z >= zero {
					dp[i][z][o] = max(dp[i][z][o], dp[i-1][z-zero][o-one]+1)
				}
			}
		}
	}

	return dp[len(strs)][m][n]
}

func findMaxForm_lessMem(strs []string, m int, n int) int {
	// 01背包变形
	var max func(i, j int) int
	var count func(v string) (one, zero int)

	max = func(i, j int) int {
		if i > j {
			return i
		}

		return j
	}
	count = func(v string) (one, zero int) {
		for _, v1 := range v {
			if v1 == '0' {
				zero++
			} else {
				one++
			}
		}
		return
	}

	dp := make([][]int, m+1)
	for i := 0; i <= m; i++ {
		dp[i] = make([]int, n+1)
	}

	for i := 0; i < len(strs); i++ {
		one, zero := count(strs[i])
		for z := m; z >= 0; z-- {
			for o := n; o >= 0; o-- {
				dp[z][o] = dp[z][o]
				if o >= one && z >= zero {
					dp[z][o] = max(dp[z][o], dp[z-zero][o-one]+1)
				}
			}
		}
	}

	return dp[m][n]
}

func max(i, j int) int {
	if i > j {
		return i
	}

	return j
}
