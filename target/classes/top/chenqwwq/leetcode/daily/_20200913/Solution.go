package _20200913

/**
 * @author chen
 * @date: 2020/9/13 上午12:35
 * @description:
 *
 */

/**
79. 单词搜索
给定一个二维网格和一个单词，找出该单词是否存在于网格中。
单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

示例:
board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

给定 word = "ABCCED", 返回 true
给定 word = "SEE", 返回 true
给定 word = "ABCB", 返回 false

提示：

board 和 word 中只包含大写和小写英文字母。
1 <= board.length <= 200
1 <= board[i].length <= 200
1 <= word.length <= 10^3
*/

func exist(board [][]byte, word string) bool {

	op := [][]int{
		{0, 1},
		{1, 0},
		{0, -1},
		{-1, 0},
	}
	i, j := len(board), len(board[0])
	// 回溯 从x,y开始找,idx的字符
	var backtracking func(idx, x, y int) bool

	backtracking = func(idx, x, y int) bool {
		if idx == len(word) {
			return true
		}
		// 越界
		if x < 0 || x >= i || y < 0 || y >= j {
			return false
		}
		// 不同
		if board[x][y] != word[idx] {
			return false
		}

		// 相同
		board[x][y] = byte(1)
		for _, v := range op {
			if backtracking(idx+1, x+v[0], y+v[1]) {
				return true
			}
		}
		board[x][y] = word[idx]
		return false
	}

	for x := 0; x < i; x++ {
		for y := 0; y < j; y++ {
			if backtracking(0, x, y) {
				return true
			}
		}
	}

	return false

}
