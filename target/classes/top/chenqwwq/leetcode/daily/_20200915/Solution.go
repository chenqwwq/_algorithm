package _20200915

/**
  @user: chenqwwq
  @date: 2020/9/15
*/

func solveSudoku(board [][]byte){
	// 三个维度的判断
	horizontal, vertical, jiugongge := make([][]bool, 9), make([][]bool, 9), make([][][]bool, 3)
	for i := 0; i < 9; i++ {
		horizontal[i] = make([]bool, 9)
		vertical[i] = make([]bool, 9)
	}
	for i := 0; i < 3; i++ {
		jiugongge[i] = make([][]bool, 3)
		for j := 0; j < 3; j++ {
			jiugongge[i][j] = make([]bool, 9)
		}
	}

	cnt := 0
	// 初始化
	for i := 0; i < 9; i++ {
		for j := 0; j < 9; j++ {
			if board[i][j] == '.' {
				cnt++
				continue
			}
			num := board[i][j] - '0' - 1
			horizontal[i][num] = true
			vertical[j][num] = true
			jiugongge[i/3][j/3][num] = true
		}
	}

	var backtracking func(i, j int) bool

	// 水平一行一行来处理
	var getNext = func(i, j int) (q, p int) {
		q, p = i, j+1
		if p > 8 {
			q++
			p = 0
		}
		return
	}

	backtracking = func(i, j int) bool {
		if cnt == 0 {
			return true
		}
		if board[i][j] != '.' {
			return backtracking(getNext(i, j))
		}
		// 从0,8中选取
		for num := 0; num < 9; num++ {
			if horizontal[i][num] || vertical[j][num] || jiugongge[i/3][j/3][num] {
				continue
			}

			horizontal[i][num] = true
			vertical[j][num] = true
			jiugongge[i/3][j/3][num] = true
			cnt--
			board[i][j] = byte('1'+num)
			if backtracking(getNext(i, j)) {
				return true
			}
			board[i][j] = '.'
			horizontal[i][num] = false
			vertical[j][num] = false
			jiugongge[i/3][j/3][num] = false
			cnt++
		}

		return false
	}

	backtracking(0, 0)
}
