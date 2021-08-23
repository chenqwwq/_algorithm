package _20200910

import (
	"sort"
)

/**
  @user: chenqwwq
  @date: 2020/9/10
*/

/**
40. 组合总和 II
给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的每个数字在每个组合中只能使用一次。

说明：

所有数字（包括目标数）都是正整数。
解集不能包含重复的组合。
示例 1:

输入: candidates = [10,1,2,7,6,1,5], target = 8,
所求解集为:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
示例 2:

输入: candidates = [2,5,2,1,2], target = 5,
所求解集为:
[
  [1,2,2],
  [5]
]
*/

func combinationSum2(candidates []int, target int) [][]int {
	// 先排序
	// 1 1 2 5 6 7 10
	sort.Ints(candidates)

	var ans [][]int
	var dfs func(want, start int, curr []int)

	dfs = func(want, start int, curr []int) {
		if want == 0 {
			ans = append(ans, append([]int{}, curr...))
			return
		}

		for i := start; i < len(candidates); i++ {
			if want < candidates[i] {
				break
			}

			// 每层不能选取相同的数字
			if i != start && candidates[i] == candidates[i-1] {
				continue
			}

			dfs(want-candidates[i], i+1, append(curr, candidates[i]))
		}
	}

	dfs(target, 0, []int{})
	return ans
}
