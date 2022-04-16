package _1

/**
 * @author chen
 * @date: 2020/8/8 下午10:30
 */

func findKthPositive(arr []int, k int) int {
	i, idx := 1, 0

	for idx < len(arr) {
		if i < arr[idx] {
			k--
			if k == 0 {
				return i
			}
		} else {
			idx++
		}
		i++
	}

	if k > 0 {
		return i + k - 1
	}
	return i
}
