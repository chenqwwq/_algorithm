package _16_17

/**
  @user: chenqwwq
  @date: 2020/8/11
*/

/**
面试题 16.17. 连续数列
给定一个整数数组，找出总和最大的连续数列，并返回总和。

示例：

输入： [-2,1,-3,4,-1,2,1,-5,4]
输出： 6
解释： 连续子数组 [4,-1,2,1] 的和最大，为 6。
进阶：

如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
*/

func maxSubArray(nums []int) int {
	if len(nums) == 0 {
		return 0
	}
	pre, res := nums[0], nums[0]

	for i := 1; i < len(nums); i++ {
		pre = max(pre+nums[i], nums[i])
		if res < pre {
			res = pre
		}
	}

	return res
}

func max(a, b int) int {
	if a > b {
		return a
	}

	return b
}
