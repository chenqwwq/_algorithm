package _20200825

/**
  @user: chenqwwq
  @date: 2020/8/25
*/

/**
491. 递增子序列
给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。


给定数组的长度不会超过15。
数组中的整数范围是 [-100,100]。
给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。
*/

func findSubsequences(nums []int) [][]int {
	// 类似的排列组合都考虑使用回溯方法实现
	// 从头开始遍历 添加元素 dfs然后删除
	var res [][]int

	// idx 表示当前的下标
	// curr表示当前的字符串
	var backtracking func(idx int, curr *[]int)
	backtracking = func(idx int, curr *[]int) {
		if len(*curr) > 1 {
			dest := make([]int, len(*curr))
			copy(dest, *curr)
			res = append(res, dest)
		}

		// 开始当前节点的处理
		// 这里就是处理后继节点的情况
		// 需要判断的就是当前数组下的后续节点不能相同
		// 数字范围是[-100,100]，所以去重也很容易
		visit := make([]bool, 201)
		for ; idx < len(nums); idx++ {
			if visit[nums[idx]+100] {
				continue
			}
			// 判断是否需要加入
			if len(*curr) == 0 || (*curr)[len(*curr)-1] <= nums[idx] {
				visit[nums[idx] + 100] = true
				*curr = append(*curr, nums[idx])
				backtracking(idx+1, curr)
				*curr = (*curr)[:len(*curr)-1]
			}
		}
	}

	backtracking(0, &[]int{})
	return res
}
