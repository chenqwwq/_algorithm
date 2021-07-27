package top.chenqwwq.leetcode.lcof._2021._46;

/**
 * 剑指 Offer 46. 把数字翻译成字符串
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= num < 231
 *
 * @author chen
 * @date 2021-07-27
 **/
public class Solution {
	public int translateNum(int num) {
		//　常规dp

		final String s = String.valueOf(num);
		final int n = s.length();
		if (n < 1) {
			return 1;
		}

		// dp[i] 表示　0~i的数组可以翻译成几种字符串
		int[] dp = new int[n + 1];
		dp[0] = 1;dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			final int t =s.charAt(i-2) == '0' ? 26 :  (s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0');
			dp[i] = t > 25 ? dp[i - 1] : dp[i - 1] + dp[i - 2];
		}

		return dp[n];
	}
}