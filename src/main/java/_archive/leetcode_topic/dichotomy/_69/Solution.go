package _69

/**
 * @author chen
 * @date: 2021/10/10 下午10:35
 * @description:
 *
 */
func mySqrt(x int) int {
	left, right := 1, x
	for left < right {
		mid := (left + right + 1) >> 1
		if mid*mid <= x {
			left = mid
		} else {
			right = mid -1
		}
	}
	return right
}
