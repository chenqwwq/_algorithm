package main

/**
  @user: chenqwwq
  @date: 2020/9/11
*/

/**
216. 组合总和 III
找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。

说明：

所有数字都是正整数。
解集不能包含重复的组合。
示例 1:

输入: k = 3, n = 7
输出: [[1,2,4]]
示例 2:

输入: k = 3, n = 9
输出: [[1,2,6], [1,3,5], [2,3,4]]
*/
func main() {
	combinationSum3(3, 7)
}

func combinationSum3(k int, n int) [][]int {
	var ans [][]int
	flag := make([]int, 9)
	var dfs func(want, num, start int)

	dfs = func(want, cnt, start int) {
		if cnt == k {
			if want != 0 {
				return
			}
			var tmp []int
			for i, v := range flag {
				if v == 1 {
					tmp = append(tmp, i+1)
				}
			}
			ans = append(ans, tmp)
			return
		}

		for i := start; i < 9; i++ {
			if flag[i] == 1 || want-i < 1 {
				continue
			}
			flag[i] = 1
			dfs(want-i-1, cnt+1, i+1)
			flag[i] = 0
		}
	}

	dfs(n, 0, 0)
	return ans
}
