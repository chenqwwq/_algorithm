package main

import (
	"fmt"
)

/**
  @user: chenqwwq
  @date: 2021/8/20
*/

// findMedianSortedArrays
// 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
func findMedianSortedArrays(nums1 []int, nums2 []int) float64 {
	// 每次去除一半的
	n, m := len(nums1), len(nums2)
	odd := (n+m)&1 == 1
	var half int
	if odd {
		half = (n + m) >> 1
	} else {
		half = (n+m)>>1 - 1
	}
	cnt := 0
	l1, r1, l2, r2 := 0, n-1, 0, m-1

	// 如果某个数组已经遍历完了
	for cnt < half && l1 <= r1 && l2 <= r2 {
		m1, m2 := (l1+r1)/2, (l2+r2)/2
		if nums1[m1] >= nums2[m2] {
			cnt += m2 - l2 + 1
			l2 = m2 + 1
		} else if nums1[m1] < nums2[m2] {
			cnt += m1 - l1 + 1
			l1 = m1 + 1
		}
	}

	// 单个列表遍历到
	if cnt < half {
		// nums1 遍历为空
		if l1 > r1 {
			if odd {
				return float64(nums2[l2+half-cnt])
			} else {
				return float64(nums2[l2+half-cnt]+nums2[l2+half-cnt+1]) / 2
			}
		} else {
			if odd {
				return float64(nums1[l1+half-cnt])
			} else {
				return float64(nums1[l1+half-cnt]+nums1[l1+half-cnt+1]) / 2
			}
		}
	}

	return 1

}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func main() {
	arrays := findMedianSortedArrays([]int{1, 2, 3, 4, 5, 6, 7}, []int{1, 3, 5})
	fmt.Println(arrays)
}
