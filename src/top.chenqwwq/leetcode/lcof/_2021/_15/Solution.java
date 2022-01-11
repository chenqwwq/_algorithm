package top.chenqwwq.leetcode.lcof._2021._15;

/**
 * @author chen
 * @date 2021/6/2
 **/
public class Solution {
	// you need to treat n as an unsigned value
	public int hammingWeight(int n) {
		int ans = 0;
		while (n != 0) {
			n &= (n - 1);
			ans++;
		}
		return ans;
	}
}