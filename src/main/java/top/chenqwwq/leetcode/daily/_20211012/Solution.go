package main

import "math"

/**
 * @author chen
 * @date: 2021/10/12 上午6:51
 * @description:
 *
 */
func divide(dividend int, divisor int) int {
	abs := func(a int) int {
		if a < 0 {
			return -a
		}
		return a
	}
	// 取最终的符号
	pos := (divisor > 0 && dividend > 0) || (dividend < 0 && divisor < 0)
	divisor, dividend = abs(divisor), abs(dividend)
	if dividend < divisor {
		return 0
	}
	base, ans := divisor, 1
	for (base << 1) < dividend {
		base <<= 1
		ans <<= 1
	}
	ans += divide(dividend-base, divisor)
	if !pos {
		ans = -ans
	}
	if ans > math.MaxInt32 || ans < math.MinInt32 {
		return math.MaxInt32
	}
	return ans
}