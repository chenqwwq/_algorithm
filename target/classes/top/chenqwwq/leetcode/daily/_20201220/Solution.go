package _20201220

/**
  @user: chenqwwq
  @date: 2020/12/23
*/

//316. 去除重复字母
//给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
//
//注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters 相同
//
//
//
//示例 1：
//
//输入：s = "bcabc"
//输出："abc"
//示例 2：
//
//输入：s = "cbacdcbc"
//输出："acdb"
//
//
//提示：
//
//1 <= s.length <= 104
//s 由小写英文字母组成

func removeDuplicateLetters(s string) string {

	// 求hash,统计每个字母的个数
	cnt := [26]int{}
	for _, v := range s {
		cnt[v-'a']++
	}

	// 贪心保证字典序最小

	exists := [26]bool{}
	var ans []byte

	for i, _ := range s {
		ch := s[i]
		// 不存在的话就要添加
		if !exists[ch-'a'] {
			// 添加到后面，判断前置的字符
			// 如果前置的字符在后续还有并且前置的字符大于当前字符就删除
			for len(ans) != 0 && ans[len(ans)-1] > ch && cnt[ans[len(ans)-1]-'a'] > 0 {
				exists[ans[len(ans)-1]-'a'] = false
				ans = ans[0 : len(ans)-1]
			}
			ans = append(ans, ch)
			exists[ch-'a'] = true
		}
		cnt[ch-'a']--
	}

	return string(ans)

}
