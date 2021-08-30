package main

/**
  @user: chenqwwq
  @date: 2021/8/20
*/

/**
541. Reverse String II
Given a string s and an integer k, reverse the first k characters for every 2k characters counting from the start of the string.
If there are fewer than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters,
then reverse the first k characters and left the other as original.

Example 1:
Input: s = "abcdefg", k = 2
Output: "bacdfeg"

Example 2:
Input: s = "abcd", k = 2
Output: "bacd"

Constraints:
1 <= s.length <= 104
s consists of only lowercase English letters.
1 <= k <= 104
*/
func reverseStr(s string, k int) string {
	min := func(a, b int) int {
		if a > b {
			return b
		}
		return a
	}

	n := len(s)
	if n == 1 {
		return s
	}

	bs := []byte(s)

	idx := 0
	for idx < n {
		left := idx
		right := min(left+k, n) - 1

		for left < right {
			bs[left], bs[right] = bs[right], bs[left]
			right--
			left++
		}
		idx += 2 * k
	}
	return string(bs)
}
