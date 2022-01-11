package top.chenqwwq.leetcode.lcof._2021._14_1;

/**
 * @author chen
 * @date 2021/6/2
 **/
public class Solution {
	public int cuttingRope(int n) {
		if (n <= 3) {
			return n - 1;
		}
		int ans = 1;
		while (n > 4) {
			ans *= 3;
			n -= 3;
		}
		return n > 1 ? n * ans : ans;
	}
}