package _20210226

/**
  @user: chenqwwq
  @date: 2021/2/26
*/

/**
1178. 猜字谜
外国友人仿照中国字谜设计了一个英文版猜字谜小游戏，请你来猜猜看吧。
字谜的迷面 puzzle 按字符串形式给出，如果一个单词 word 符合下面两个条件，那么它就可以算作谜底：
单词 word 中包含谜面 puzzle 的第一个字母。
单词 word 中的每一个字母都可以在谜面 puzzle 中找到。
例如，如果字谜的谜面是 "abcdefg"，那么可以作为谜底的单词有 "faced", "cabbage", 和 "baggage"；而 "beefed"（不含字母 "a"）以及 "based"（其中的 "s" 没有出现在谜面中）。
返回一个答案数组 answer，数组中的每个元素 answer[i] 是在给出的单词列表 words 中可以作为字谜迷面 puzzles[i] 所对应的谜底的单词数目。

示例：
输入：
words = ["aaaa","asas","able","ability","actt","actor","access"],
puzzles = ["aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"]
输出：[1,1,3,2,4,0]
解释：
1 个单词可以作为 "aboveyz" 的谜底 : "aaaa"
1 个单词可以作为 "abrodyz" 的谜底 : "aaaa"
3 个单词可以作为 "abslute" 的谜底 : "aaaa", "asas", "able"
2 个单词可以作为 "absoryz" 的谜底 : "aaaa", "asas"
4 个单词可以作为 "actresz" 的谜底 : "aaaa", "asas", "actt", "access"
没有单词可以作为 "gaswxyz" 的谜底，因为列表中的单词都不含字母 'g'。

提示：
1 <= words.length <= 10^5
4 <= words[i].length <= 50
1 <= puzzles.length <= 10^4
puzzles[i].length == 7
words[i][j], puzzles[i][j] 都是小写英文字母。
每个 puzzles[i] 所包含的字符都不重复。
*/

func findNumOfValidWords(words []string, puzzles []string) []int {
	// 二进制状态压缩
	// 以二进制位表示字符的存在与否
	// 拆解word
	hash := map[int]int{}
	for _, word := range words {
		// 以mask表示word
		mask := 0
		for _, v := range word {
			mask |= 1 << (v - 'a')
		}
		hash[mask]++
	}

	ans := make([]int, len(puzzles))
	for i, puzzle := range puzzles {
		// puzzle的首字符
		first := 1 << (puzzle[0] - 'a')
		// 1. word 中包含 puzzle 的第一个字母
		// 2. word 中的每个字母在 puzzle 中都能找到

		// 拆解puzzle,跳过首字母
		mask := 0
		for _, v := range puzzle[1:] {
			mask |= 1 << (v - 'a')
		}

		// 首字母一定要带上，但是其他可以空出，每次都去掉最后的1
		sub := mask
		for {
			ans[i] += hash[first|sub]
			// 取出最后的1
			sub = (sub - 1) & mask
			if sub == mask {
				break
			}
		}
	}
	return ans
}

// 朴素暴力超时
//func findNumOfValidWords(words []string, puzzles []string) []int {
//
//	first, padding := int32(0), int32(1)
//
//	wHash, pHash := make([]map[int32]int32, len(words)), make([]map[int32]int32, len(puzzles))
//
//	// 检查是否可以作为谜底谜面
//	check := func(word, puzzle map[int32]int32) bool {
//		// 1. word 中包含 puzzle 的第一个字母
//		// 2. word 中的每个字母在 puzzle 中都能找到
//		_, exist := word[puzzle[first]]
//		if !exist {
//			return false
//		}
//
//		for k, _ := range word {
//			if _, exist := puzzle[k]; !exist {
//				return false
//			}
//		}
//		return true
//	}
//
//	// 拆解words
//	for idx, word := range words {
//		tmp := make(map[int32]int32)
//		for _, v := range word {
//			tmp[v] = padding
//		}
//		wHash[idx] = tmp
//	}
//
//	// 拆解puzzle
//	for idx, puzzle := range puzzles {
//		tmp := make(map[int32]int32)
//		for i, v := range puzzle {
//			if i == 0 {
//				tmp[first] = v
//			}
//			tmp[v] = padding
//		}
//		pHash[idx] = tmp
//	}
//
//	l := len(pHash)
//	res := make([]int, l)
//	for i := 0; i < l; i++ {
//		for _, v := range wHash {
//			if check(v, pHash[i]) {
//				res[i]++
//			}
//		}
//	}
//	return res
//}
