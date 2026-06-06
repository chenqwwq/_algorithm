package top.chenqwwq.leetcode.daily._2021._20210926;

/**
 * @author chen
 * @date 2021-09-26
 **/
public class Solution {
	public int getSum(int a, int b) {
		if (b == 0) {
			return a;
		}
		return getSum(a ^ b, (a & b) << 1);
	}
}