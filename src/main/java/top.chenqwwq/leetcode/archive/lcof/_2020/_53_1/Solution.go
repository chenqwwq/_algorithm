package _53_1

/**
  @user: chenqwwq
  @date: 2020/7/24
*/

/**
剑指 Offer 53 - I. 在排序数组中查找数字 I
统计一个数字在排序数组中出现的次数。
*/

func search(nums []int, target int) int {
	if len(nums) == 0 {
		return 0
	}

	low, high := 0, len(nums)-1

	for low <= high {
		mid := low + (high-low)>>1

		if target > nums[mid] {
			low = mid + 1
			continue
		}

		if target < nums[mid] {
			high = mid - 1
			continue
		}

		// 相等的情况
		res, t := 0, mid
		for t >= 0 && nums[t] == target {
			res++
			t--
		}

		mid++
		for mid < len(nums) && nums[mid] == target {
			res++
			mid++
		}

		return res
	}

	return 0
}
