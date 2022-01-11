package top.chenqwwq.leetcode.daily._20210530;

/**
 * @author chen
 * @date 2021/5/30
 **/
public class Solution {
	public boolean isPowerOfTwo(int n) {
		return n > 0 && (n & n - 1) == 0;
	}

}