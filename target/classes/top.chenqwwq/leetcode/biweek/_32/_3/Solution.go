package _3

/**
 * @author chen
 * @date: 2020/8/8 下午11:08
 */

func minInsertions(s string) int {
	// i表示(的数目,j表示)的数目
	i, j := 0, 0
	// result
	res := 0
	for _, v := range s {
		if v == '(' {
			if j == 1 {
				if i > 0 {
					res += 1
					i--
					j--
				} else {
					res += 2
					j = 0
				}
			}
			i++
		} else {
			// )
			if j == 1 {
				if i == 0 {
					res++
				} else {
					i--
				}
				j = 0
			} else {
				j++
			}
		}
	}

	if i != 0 {
		// 需要 2*i个j
		res += 2*i - j
		j = 0
	}
	if j != 0 {
		if j&1 == 1 {
			res++
			j++
		}
		res += j / 2
	}

	return res
}
