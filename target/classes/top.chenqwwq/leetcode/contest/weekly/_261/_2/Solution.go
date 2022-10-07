package _2

/**
 * @author chen
 * @date: 2021/10/5 11:16 下午
 * @description:
 *
 */

func missingRolls(rolls []int, mean int, n int) []int {
	if n == 0 {
		return []int{}
	}
	total := mean * (len(rolls) + n)
	sum := 0
	for _, v := range rolls {
		sum += v
	}
	target := total - sum
	// 10 / 3
	if 6*n < target || target < n {
		return []int{}
	}
	// 1
	min, cnt := target/n, target%n
	ans := make([]int, n)
	for i := 0; i < n; i++ {
		if i < cnt {
			ans[i] = min + 1
		} else {
			ans[i] = min
		}
	}
	return ans
}
