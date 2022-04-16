package _3

/**
 * @author chen
 * @date: 2021/10/5 11:29 下午
 * @description:
 *
 */

func stoneGameIX(stones []int) bool {
	cnt := make([]int, 3)
	for _, v := range stones {
		cnt[v%3]++
	}

	if cnt[0] % 2 == 0 {
		return cnt[1] != 0 && cnt[2] != 0
	}
	return cnt[2] > cnt[1] + 2 || cnt[1] > cnt[2] + 2
}
