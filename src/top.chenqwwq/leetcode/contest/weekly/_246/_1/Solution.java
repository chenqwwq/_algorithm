package top.chenqwwq.leetcode.contest.weekly._246._1;

/**
 * @author chen
 * @date 2021/6/20
 **/
public class Solution {
	public String largestOddNumber(String num) {
		for (int i = num.length() - 1; i >= 0; i--) {
			if (((num.charAt(i) - '0') & 1) == 1) {
				return num.substring(0, i);
			}
		}
		return "";
	}
}