package _1

/**
 * @author chen
 * @date: 2020/9/5 下午10:34
 * @description:
 *
 */

func diagonalSum(mat [][]int) int {
	if len(mat) == 0 {
		return 0
	}
	n := len(mat)
	res := 0
	for i := 0; i < n; i++ {
		res += mat[i][i]
		res += mat[i][n-1-i]
	}

	if n&1 == 1 {
		j := n >> 1
		res -= mat[j][j]
	}
	return res
}
