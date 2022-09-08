package _59_1

/**
  @user: chenqwwq
  @date: 2020/7/24
*/

/**
剑指 Offer 59 - I. 滑动窗口的最大值
给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
*/

func maxSlidingWindow(nums []int, k int) []int {
	if len(nums) < k {
		return []int{}
	}

	i, sum := 0, 0
	var res []int

	for i < k {
		sum += nums[i]
		i++
	}

	res = append(res, sum)

	for ; i < len(nums); i++ {
		sum += nums[i]
		sum -= nums[i-k]
		res = append(res, sum)
	}

	return res
}
