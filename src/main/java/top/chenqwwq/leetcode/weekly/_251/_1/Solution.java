package top.chenqwwq.leetcode.weekly._251._1;

/**
 * @author chen
 * @date 2021/7/25
 **/
public class Solution {
	public int getLucky(String s, int k) {
		int ans = 0;
		for (char c : s.toCharArray()) {
			ans += getNumBitSum(c - 'a' + 1);
		}
		while (--k > 0) {
			ans = getNumBitSum(ans);
		}
		return ans;
	}

	public int getNumBitSum(int num) {
		int sum = 0;
		while (num > 0) {
			sum += (num % 10);
			num /= 10;
		}
		return sum;
	}
}