package _20200920

/**
 * @author chen
 * @date: 2020/9/20 下午6:09
 * @description:
 *
 */

/*
78. Subsets
Given a set of distinct integers, nums, return all possible subsets (the power set).
Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/

func subsets(nums []int) [][]int {
	var ans [][]int

	var dfs func(curr []int, idx int)

	dfs = func(curr []int, idx int) {
		if idx == len(nums) {
			ans = append(ans, append([]int{}, curr...))
			return
		}

		// 当前的节点选还是不选
		curr = append(curr, nums[idx])
		dfs(curr, idx+1)
		curr = curr[:len(curr)-1]
		dfs(curr, idx+1)
	}

	dfs([]int{}, 0)

	return ans
}
