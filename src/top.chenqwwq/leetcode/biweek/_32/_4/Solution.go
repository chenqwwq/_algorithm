package _4

/**
 * @author chen
 * @date: 2020/8/8 下午11:32
 */

func longestAwesome(s string) int {
	arr := []rune(s)

	sLen := len(s)
	dp := make([][]int, sLen)
	for i := 0; i < sLen; i++ {
		dp[i] = make([]int, sLen)
		dp[i][i] = 1
	}

	for i := 1; i < sLen; i++ {
		for j := 0; j < i; j++ {
			if arr[i] == arr[j] {
				if i-j == 1 {
					dp[i][j] = 2
				} else {
					dp[i][j] = dp[i-1][j-1] + 2
				}
			}
		}
	}

}
