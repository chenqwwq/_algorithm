package top.chenqwwq.leetcode.archive.lcof2._3;

/**
 * 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24
 * 0 1 1 2 1 2 2 3 1 2 2  3  2  3  3  4  1  2  2  3  2  3  3  4  2
 * @author chenbingxin
 * @date 2021/12/3
 **/
public class Solution {
	public int[] countBits(int n) {
		final int[] ans = new int[n+1];
		ans[0] = 0;

		for (int i = 1;i <= n;i++){
			ans[i] = ans[i & (i-1)] + 1;
		}
		return ans;
	}
}