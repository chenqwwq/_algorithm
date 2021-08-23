package _20200819

/**
  @user: chenqwwq
  @date: 2020/8/21
*/

/**
647. 回文子串
给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。

具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。

*/

func countSubstrings(s string) int {
	ap := *pre(s)
	p := make([]int, len(ap))

	for i := 1; i < len(p)-1; i++ {
		num := 0
		for ; i-num >= 0 && i+num < len(p) && ap[i-num] == ap[i+num]; num++ {
		}
		p[i] = num - 1
	}

	res := 0
	for _, num := range p {
		res += (num + 1) / 2
	}

	return res
}

func pre(s string) *[]uint8 {
	res := make([]uint8, 2*len(s)+1)

	res[0] = '#'
	for i, j := 0, 1; i < len(s) && j < len(res); i, j = i+1, j+2 {
		res[j] = s[i]
		res[j+1] = '#'
	}

	res[2*len(s)] = '#'
	return &res
}
