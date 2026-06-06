package _53_2

/**
  @user: chenqwwq
  @date: 2020/7/24
*/

/**
剑指 Offer 53 - II. 0～n-1中缺失的数字
一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
*/

func missingNumber(nums []int) int {
	if len(nums) == 0 {
		return 0
	}

	low, high := 0, len(nums)-1

	for low <= high {
		// 求中间数
		mid := low + (high-low)>>1

		// 实际数比求得数小，在右侧
		if mid >= nums[mid] {
			low = mid + 1
			continue
		}

		if mid < nums[mid] {
			high = mid - 1
			continue
		}
	}

	return low
}
