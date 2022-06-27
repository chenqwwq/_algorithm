package _2

import "math"

/**
 * @author chen
 * @date: 2020/8/8 下午10:42
 */

func canConvertString(s string, t string, k int) bool {
	if len(s) != len(t) {
		return false
	}

	nums := make(map[int]int)
	sb := []rune(s)
	st := []rune(t)

	for i := 0; i < len(s); i++ {
		//A、B、C、D、E、F、G、H、I、J、K、L、M、N、O、P、Q、R、S、T、U、V、W、X、Y、Z。
		r := st[i] - sb[i]
		if r != 0 {
			if r < 0 {
				r += 26
			}
			nums[int(r)]++
		}
	}

	res := math.MinInt64
	for k, v := range nums {
		res = max(k+(v-1)*26, res)
	}

	return res <= k
}

func max(i, j int) int {
	if i > j {
		return i
	}
	return j
}
