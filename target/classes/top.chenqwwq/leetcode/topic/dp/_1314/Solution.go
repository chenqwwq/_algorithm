package _1314

/**
  @user: chenqwwq
  @date: 2020/8/13
*/

/**
1314. 矩阵区域和
给你一个 m * n 的矩阵 mat 和一个整数 K ，请你返回一个矩阵 answer ，其中每个 answer[i][j] 是所有满足下述条件的元素 mat[r][c] 的和：

i - K <= r <= i + K, j - K <= c <= j + K
(r, c) 在矩阵内。




提示：

m == mat.length
n == mat[i].length
1 <= m, n, K <= 100
1 <= mat[i][j] <= 100
*/

func matrixBlockSum(mat [][]int, K int) [][]int {
	// 二维数组的前缀和
	// 两趟的遍历逻辑更加清晰
	// 可以收缩为一趟遍历

	// 预处理
	v := len(mat)
	h := len(mat[0])
	sat := make([][]int, v+1)
	for i := 0; i <= v; i++ {
		sat[i] = make([]int, h+1)
	}
	for i := 1; i <= v; i++ {
		for j := 1; j <= h; j++ {
			sat[i][j] = sat[i-1][j] + sat[i][j-1] - sat[i-1][j-1] + mat[i-1][j-1]
		}
	}

	ans := make([][]int, v)
	for i := 0; i < v; i++ {
		ans[i] = make([]int, h)
	}

	for i := 1; i <= v; i++ {
		for j := 1; j <= h; j++ {
			// 两点的坐标
			x1, y1, x2, y2 := min(i+K, v), min(j+K, h), max(i-K-1, 0), max(j-K-1, 0)
			ans[i-1][j-1] = sat[x1][y1] - sat[x1][y2] - sat[x2][y1] + sat[x2][y2]
		}
	}

	return ans
}

// max 和 min 用于处理边界情况
func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func min(a, b int) int {
	if a > b {
		return b
	}
	return a
}
