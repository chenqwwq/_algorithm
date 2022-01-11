package top.chenqwwq.leetcode.lcof._2021._58_2;

/**
 * @author chen
 * @date 2021-07-09
 **/
public class Solution {
	public String reverseLeftWords(String s, int n) {
		return (n %= s.length()) == 0 ? s : s.substring(n) + s.substring(0, n);
	}
}