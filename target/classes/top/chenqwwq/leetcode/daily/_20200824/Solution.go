package _20200824

/**
  @user: chenqwwq
  @date: 2020/8/24
*/

/**
459. 重复的子字符串
给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。

*/

func repeatedSubstringPattern(s string) bool {
	if len(s) == 0 || len(s)&1 == 1 {
		return false
	}

	for i, mid := 0, len(s)>>1; mid < len(s); i, mid = i+1, mid+1 {
		if s[i] != s[mid]{
			return false
		}
	}

	return true
}


