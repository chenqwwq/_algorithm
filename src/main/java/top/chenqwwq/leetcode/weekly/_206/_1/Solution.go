package _1

/**
 * @author chen
 * @date: 2020/9/13 上午10:31
 * @description:
 *
 */

func numSpecial(mat [][]int) int {
	x := make([]int, len(mat))
	y := make([]int, len(mat[0]))
	for i := 0; i < len(mat); i++ {
		for j := 0; j < len(mat[0]); j++ {
			x[i] += mat[i][j]
			y[j] += mat[i][j]
		}
	}

	ans := 0
	for i, v := range x {
		for j, v1 := range y {
			if v == 1 && v1 == 1 && mat[i][j] == 1 {
				ans++
			}
		}
	}

	return ans
}
