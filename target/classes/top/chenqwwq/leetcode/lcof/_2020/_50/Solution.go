package _50

/**
  @user: chenqwwq
  @date: 2020/7/22
*/

/**
剑指 Offer 50. 第一个只出现一次的字符
在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。

示例:
s = "abaccdeff"
返回 "b"
s = ""
返回 " "

限制：
0 <= s 的长度 <= 50000
*/
func firstUniqChar(s string) byte {
	runes := []rune(s)
	ints := [26]int{}

	for _, v := range runes {
		ints[v-'a']++
	}

	for k, v := range runes {
		if ints[v-'a'] == 1 {
			return s[k]
		}
	}
	return ' '

}
