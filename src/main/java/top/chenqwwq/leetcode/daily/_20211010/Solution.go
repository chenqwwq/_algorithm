package main

/**
 * @author chen
 * @date: 2021/10/10 下午1:28
 * @description:
 *
 */
func arrangeCoins(n int) int {
	left, right := 1, n
	for left < right {
		mid := (left + right + 1) >> 1
		target := (mid + 1) * mid / 2
		if target <= n {
			left = mid
		} else {
			right = mid - 1
		}
	}
	return right
}
