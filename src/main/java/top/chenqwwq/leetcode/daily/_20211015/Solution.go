package main

import "strconv"

/**
 * @author chen
 * @date: 2021/10/15 下午11:22
 * @description:
 *
 */

func countAndSay(n int) string {
	ans := "1"
	for n > 1 {
		tmp, cnt, num := "", 0, int32(ans[0])
		for _, v := range ans {
			if v == num {
				cnt++
			} else {
				tmp = tmp + strconv.Itoa(cnt) + strconv.Itoa(int(num-48))
				cnt, num = 1, v
			}
		}
		ans = tmp + strconv.Itoa(cnt) + strconv.Itoa(int(num-48))
		n--
	}
	return ans
}