package _20210822

/**
 * @author chen
 * @date: 2021/8/22 下午1:16
 * @description:
 *
 */
func escapeGhosts(ghosts [][]int, target []int) bool {
	abs := func(num int) int {
		if num < 0 {
			return -num
		}
		return num
	}
	dist := func(x, y, a, b int) int {
		return abs(x-a) + abs(y-b)
	}

	distance := dist(0, 0, target[0], target[1])

	for _, v := range ghosts {
		if distance >= dist(v[0], v[1], target[0], target[1]) {
			return false
		}
	}
	return true

}
