package _2

/**
 * @author chen
 * @date: 2020/9/13 上午10:47
 * @description:
 *
 */

func unhappyFriends(n int, preferences [][]int, pairs [][]int) int {
	// 关系的下标
	ref := make([]map[int]int, n)

	for idx, pre := range preferences {
		refMap := make(map[int]int)
		for i, v := range pre {
			refMap[v] = i
		}
		ref[idx] = refMap
	}

	pairMap := make(map[int]int)
	for _, v := range pairs {
		pairMap[v[0]] = v[1]
		pairMap[v[1]] = v[0]
	}

	ans := 0

	for i := 0; i < n; i++ {
		for _, v := range preferences[i] {
			if v == pairMap[i] {
				break
			}

			// 查看v和i的关系是不是大于v和配置的关系
			if ref[v][i] < ref[v][pairMap[v]] {
				ans++
				break
			}
		}
	}

	return ans
}
