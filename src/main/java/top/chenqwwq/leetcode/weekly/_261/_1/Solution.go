package _1

/**
 * @author chen
 * @date: 2021/10/5 9:41 下午
 * @description:
 *
 */

func minimumMoves(s string) int {
	n, ans := len(s), 0
	for i := 0; i < n; {
		if s[i] == 'X' {
			ans++
			i += 3
		} else {
			i++
		}
	}
	return ans
}
