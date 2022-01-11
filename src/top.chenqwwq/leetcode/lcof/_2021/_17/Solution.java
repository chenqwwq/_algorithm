package top.chenqwwq.leetcode.lcof._2021._17;

/**
 * @author chen
 * @date 2021/6/3
 **/
public class Solution {
	public int[] printNumbers(int n) {
		int max = 0;
		while (n > 0) {
			max = max * 10 + 9;
			n--;
		}
		int[] ans = new int[max ];
		for (int i = 1; i <= max; i++) {
			ans[i - 1] = i;
		}
		return ans;
	}
}