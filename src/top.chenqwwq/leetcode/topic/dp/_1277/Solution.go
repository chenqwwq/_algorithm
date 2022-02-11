package _1277

/**
  @user: chenqwwq
  @date: 2020/8/13
*/

/**
1277. 统计全为 1 的正方形子矩阵
给你一个 m * n 的矩阵，矩阵中的元素不是 0 就是 1，请你统计并返回其中完全由 1 组成的 正方形 子矩阵的个数。


提示：

1 <= arr.length <= 300
1 <= arr[0].length <= 300
0 <= arr[i][j] <= 1

*/

func countSquares(matrix [][]int) int {
	// 直接使用matrix数组当dp数组
	res := 0

	// 预处理
	for i := 0; i < len(matrix); i++ {
		res += matrix[i][0]
	}

	for i := 1; i < len(matrix[0]); i++ {
		res += matrix[0][i]
	}

	for i := 1; i < len(matrix); i++ {
		for j := 1; j < len(matrix[0]); j++ {
			if matrix[i][j] == 0 {
				continue
			}
			matrix[i][j] = min(matrix[i-1][j-1], matrix[i-1][j], matrix[i][j-1]) + 1
			res += matrix[i][j]
		}
	}

	return res
}

func min(a, b, c int) int {
	m := a
	if m > b {
		m = b
	}
	if m > c {
		m = c
	}
	return m

}
