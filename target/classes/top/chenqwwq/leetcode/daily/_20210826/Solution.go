package main

import "sort"

/**
  @user: chenqwwq
  @date: 2021/8/26
*/
func numRescueBoats(people []int, limit int) int {
	n := len(people)
	sort.Ints(people)
	// 最多一次坐两个人 最多limit的重量
	l, r, ans := 0, n-1, 0
	for l <= r {
		if people[l]+people[r] <= limit {
			r--
			l++
		} else {
			r--
		}
		ans++
	}
	return ans
}