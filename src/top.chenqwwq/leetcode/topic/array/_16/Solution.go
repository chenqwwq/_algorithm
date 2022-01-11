package _16

import (
	"math"
	"sort"
)

/**
  @user: chenqwwq
  @date: 2020/9/9
*/

func threeSumClosest(nums []int, target int) int {
	// 排序
	sort.Ints(nums)
	// answer
	ans := -1
	midDiff := math.MaxInt32
	for i := 0; i < len(nums)-2; i++ {
		left, right := i+1, len(nums)-1

		for left < right {
			sum := nums[i] + nums[left] + nums[right]
			currDiff := abs(target - sum)
			if currDiff < midDiff {
				midDiff = currDiff
				ans = sum
			}
			if sum > target {
				right--
			} else if sum < target {
				left++
			} else {
				return sum
			}
		}
	}
	return ans
}

func abs(num int) int {
	if num < 0 {
		return -num
	}
	return num
}
