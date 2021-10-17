package main

import (
	"strconv"
)

/**
 * @author chen
 * @date: 2021/10/16 下午4:27
 * @description:
 *
 */
func addOperators(num string, target int) []string {
	n := len(num)
	var ans []string
	// 回溯
	// curr 当前的字符串
	// i 下标
	// val 当前值
	var backtrack func(curr string, i, val, prev int)
	backtrack = func(curr string, i, val, prev int) {
		if i == n {
			if target == val {
				ans = append(ans, curr)
			}
			return
		}
		for j := i + 1; j <= n; j++ {
			if j != i+1 && num[i] == '0' {
				break
			}
			str := num[i:j]
			t, _ := strconv.Atoi(str)
			if i != 0 {
				backtrack(curr+"+"+str, j, val+t, t)
				backtrack(curr+"-"+str, j, val-t, -t)
				backtrack(curr+"*"+str, j, (val-prev)+(prev*t), t*prev)
			} else {
				backtrack(str, j, t, t)
			}
		}
		return
	}

	backtrack("", 0, 0, 0)
	return ans
}