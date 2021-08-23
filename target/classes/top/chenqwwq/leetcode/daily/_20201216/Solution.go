package _20201216

import (
	"strings"
)

/**
  @user: chenqwwq
  @date: 2020/12/16
*/

/**
290. 单词规律
给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。

这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。

示例1:

输入: pattern = "abba", str = "dog cat cat dog"
输出: true
示例 2:

输入:pattern = "abba", str = "dog cat cat fish"
输出: false
示例 3:

输入: pattern = "aaaa", str = "dog cat cat dog"
输出: false
示例 4:

输入: pattern = "abba", str = "dog dog dog dog"
输出: false
说明:
你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。
*/

func wordPattern(pattern string, s string) bool {
	afterSplit := strings.Split(s, " ")
	if len(pattern) != len(afterSplit) {
		return false
	}

	hash := map[uint8]string{}
	hash2 := map[string]uint8{}

	for i, _ := range pattern {
		if v, ok := hash[pattern[i]]; ok && v != afterSplit[i] {
			return false
		}

		if v1, ok := hash2[afterSplit[i]]; ok && v1 != pattern[i] {
			return false
		}

		hash[pattern[i]], hash2[afterSplit[i]] = afterSplit[i], pattern[i]
	}
	return true
}
