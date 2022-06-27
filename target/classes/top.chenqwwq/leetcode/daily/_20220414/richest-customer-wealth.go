package _20220414

/**
 * @author chen
 * @date: 2022/4/14
 * @description:
 **/

func maximumWealth(accounts [][]int) int {
	ans := 0
	for _, value := range accounts {
		sum := 0
		for _, v := range value {
			sum += v
		}
		if sum > ans {
			ans = sum
		}
	}
	return ans
}
