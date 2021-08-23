package _20200903

/**
  @user: chenqwwq
  @date: 2020/9/3
*/

/**
51. N 皇后
n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。

上图为 8 皇后问题的一种解法。
给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
*/

/*8
示例：

输入：4
输出：[
 [".Q..",  // 解法 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // 解法 2
  "Q...",
  "...Q",
  ".Q.."]
]
解释: 4 皇后问题存在两个不同的解法。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/n-queens
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

func solveNQueens(n int) [][]string {
	// 回溯算法
	var res [][]string
	var chessboard [][]byte
	for i := 0; i < n; i++ {
		chessboard = append(chessboard, make([]byte, n))
		for j := 0; j < n; j++ {
			chessboard[i][j] = '.'
		}
	}
	// 纵向是否正确
	vertical := make([]bool, n)
	// 斜线是否正确  (i,j) -> slash[]
	slash := make([]bool, 2*n-1)
	backslash := make([]bool, 2*n-1)

	var backtracking func(idx int)

	backtracking = func(idx int) {
		if idx == n {
			// 添加到答案
			var temp []string
			for i := 0; i < n; i++ {
				temp = append(temp, string(chessboard[i]))
			}
			res = append(res, temp)
			return
		}
		// 第idx行决定放哪里
		for i := 0; i < n; i++ {
			// 先检查
			if vertical[i] || slash[idx+i] || backslash[idx-i+n-1] {
				continue
			}
			chessboard[idx][i] = 'Q'
			vertical[i] = true
			slash[idx+i] = true
			backslash[idx-i+n-1] = true
			backtracking(idx + 1)
			vertical[i] = false
			slash[idx+i] = false
			backslash[idx-i+n-1] = false
			chessboard[idx][i] = '.'
		}
	}

	backtracking(0)
	return res
}
