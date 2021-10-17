package _20211013

import (
	"strconv"
)

/**
 * @author chen
 * @date: 2021/10/13 上午7:14
 * @description:
 *
 */
func fizzBuzz(n int) []string {
	ans := make([]string, n)
	for i := 0; i < n; i++ {
		target := i + 1
		if target%3 == 0 && target%5 == 0 {
			ans[i] = "FizzBuzz"
		} else if target%3 == 0 {
			ans[i] = "Fizz"
		} else if target%5 == 0 {
			ans[i] = "Buzz"
		} else {
			ans[i] = strconv.Itoa(target)
		}
	}
	return ans
}
