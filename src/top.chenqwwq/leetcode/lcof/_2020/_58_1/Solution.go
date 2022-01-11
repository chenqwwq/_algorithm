package _58_1

import "strings"

/**
  @user: chenqwwq
  @date: 2020/7/24
*/

/**
剑指 Offer 58 - I. 翻转单词顺序
输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
*/

func reverseWords(s string) string {
	if len(s) == 0 {
		return s
	}

	split := strings.Split(s, " ")
	var res []string

	for i := len(split) - 1; i >= 0; i-- {

		s := strings.TrimSpace(split[i])
		if len(s) > 0 {
			res = append(res, s)
		}
	}

	return strings.Join(res, " ")
}
