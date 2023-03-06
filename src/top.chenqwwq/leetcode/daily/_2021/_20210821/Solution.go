package main

import "strconv"

/**
 * @author chen
 * @date: 2021/8/21 下午4:17
 * @description:
 *
 */
func compress(chars []byte) int {
	n := len(chars)
	// 读写双指针
	writer, reader := 0, 0

	for reader < n {
		c, cnt := chars[reader], 1
		for reader+1 < n && c == chars[reader+1] {
			reader++
			cnt++
		}
		chars[writer] = c
		writer++
		if cnt > 1 {
			for _, v := range []byte(strconv.Itoa(cnt)) {
				chars[writer] = v
				writer++
			}
		}
		reader++
	}
	return writer
}
