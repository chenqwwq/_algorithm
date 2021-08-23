package _2

/**
 * @author chen
 * @date: 2020/9/5 下午10:41
 * @description:
 *
 */

const MOD = 10e8+7

func numWays(s string) int {
	// 找出所有的1
	var arr []int64
	for idx, by := range s {
		if by == '1' {
			arr = append(arr, int64(idx))
		}
	}

	// 处理没有1 或者 1不能整除的异常
	if len(arr) == 0 {
		i := len(s)
		return (((i - 2) * (i - 1)) / 2) % MOD
	}
	if len(arr)%3 != 0 {
		return 0
	}

	oneNum := len(arr) / 3

	res := (arr[oneNum] - arr[oneNum-1]) * (arr[2*oneNum] - arr[2*oneNum-1])

	return int(res % MOD)
}
