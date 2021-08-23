package _20200918

import "sort"

/**
  @user: chenqwwq
  @date: 2020/9/18
*/

/**
47. 全排列 II
给定一个可包含重复数字的序列，返回所有不重复的全排列。

示例:
输入: [1,1,2]
输出:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
*/

func permuteUnique(nums []int) [][]int {
	sort.Ints(nums)
	lenNum := len(nums)
	flag := make([]bool, lenNum)
	var ans []int
	var res [][]int
	var backtracking func()

	backtracking = func() {
		if len(ans) == lenNum {
			res = append(res, append([]int{}, ans...))
			return
		}
		for i := 0; i < len(flag); i++ {
			if flag[i] || i > 0 && nums[i-1] == nums[i] && !flag[i-1] {
				continue
			}

			flag[i] = true
			ans = append(ans, nums[i])
			backtracking()
			ans = ans[:len(ans)-1]
			flag[i] = false
		}
	}

	backtracking()

	return res
}
