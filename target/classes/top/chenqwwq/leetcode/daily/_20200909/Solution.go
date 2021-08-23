package _20200909

/**
  @user: chenqwwq
  @date: 2020/9/9
*/

/**
39. 组合总和
给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
candidates 中的数字可以无限制重复被选取。

说明：
所有数字（包括 target）都是正整数。
解集不能包含重复的组合。

示例 1：
输入：candidates = [2,3,6,7], target = 7,
所求解集为：
[
  [7],
  [2,2,3]
]

示例 2：
输入：candidates = [2,3,5], target = 8,
所求解集为：
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]

提示：
1 <= candidates.length <= 30
1 <= candidates[i] <= 200
candidate 中的每个元素都是独一无二的。
1 <= target <= 500
*/

func combinationSum(candidates []int, target int) [][]int {
	var ans [][]int
	var curr []int

	// want 表示希望的数字
	// start 表示当前回合从哪里开始
	var dfs func(want, start int)

	dfs = func(want, start int) {
		if start >= len(candidates) {
			return
		}
		if want == 0 {
			tmp := make([]int, len(curr))
			for i := 0; i < len(curr); i++ {
				tmp[i] = curr[i]
			}
			ans = append(ans, tmp)
			return
		}

		for i := start; i < len(candidates); i++ {
			v := candidates[i]
			if want < v {
				continue
			}
			curr = append(curr, v)
			dfs(want-v, i)
			curr = curr[:len(curr)-1]
		}
	}

		dfs(target, 0)
	return ans
}
