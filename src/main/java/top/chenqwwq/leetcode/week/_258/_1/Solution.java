package top.chenqwwq.leetcode.week._258._1;

/**
 * @author chen
 * @date 2021/9/12
 **/
public class Solution {
	public String reversePrefix(String word, char ch) {
		int i = 0;
		if ((i = word.indexOf(ch)) <= 0) {
			return word;
		}
		return new StringBuffer(word.substring(0, i + 1)).reverse() + word.substring(i + 1);
	}
}