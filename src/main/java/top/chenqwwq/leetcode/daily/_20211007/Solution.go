package main

/**
 * @author chen
 * @date: 2021/10/7 下午1:10
 * @description:
 *
 */

func countSegments(s string) int {
	ans, n := 0, len(s)
	for i := 0;i < n ; {
		if s[i] == ' '{
			i++
			continue
		}else{
			ans++
			for i < n && s[i] != ' ' {
				i++
				continue
			}
		}
	}
	return ans
}