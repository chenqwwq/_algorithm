package top.chenqwwq.leetcode.daily._20210927;

/**
 * 一条包含字母 A-Z 的消息通过以下的方式进行了编码：
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 要 解码 一条已编码的消息，所有的数字都必须分组，然后按原来的编码方案反向映射回字母（可能存在多种方式）。例如，"11106" 可以映射为：
 * <p>
 * "AAJF" 对应分组 (1 1 10 6)
 * "KJF" 对应分组 (11 10 6)
 * 注意，像 (1 11 06) 这样的分组是无效的，因为 "06" 不可以映射为 'F' ，因为 "6" 与 "06" 不同。
 * <p>
 * 除了 上面描述的数字字母映射方案，编码消息中可能包含 '*' 字符，可以表示从 '1' 到 '9' 的任一数字（不包括 '0'）。
 * 例如，编码字符串 "1*" 可以表示 "11"、"12"、"13"、"14"、"15"、"16"、"17"、"18" 或 "19" 中的任意一条消息。对 "1*" 进行解码，相当于解码该字符串可以表示的任何编码消息。
 * <p>
 * 给你一个字符串 s ，由数字和 '*' 字符组成，返回 解码 该字符串的方法 数目 。
 * <p>
 * 由于答案数目可能非常大，返回对 109 + 7 取余 的结果。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-ways-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chen
 * @date 2021-09-27
 **/
public class Solution {
	private static final int mod = (int) 1e9 + 7;
	private int[] arr = new int[]{0, 9, 6, 0, 0, 0, 0, 0, 0, 0};
	private int[] arr1 = new int[]{0, 2, 2, 2, 2, 2, 2, 0, 0, 0};

	public int numDecodings(String s) {
		final int n = s.length();
		long[] dp = new long[n];
		dp[0] = s.charAt(0) == '*' ? 9 : s.charAt(0) == '0' ? 0 : 1;
		for (int i = 1; i < n; i++) {
			// 枚举各种状态,考虑和前驱的结合
			final char c = s.charAt(i), p = s.charAt(i - 1);
			final long prev = i >= 2 ? dp[i - 2] : 1;
			final int num = c - '0', num1 = p - '0';

			if (c == '*') {
				// 1. 当前为 * 的情况
				// 当前的字符单独解码,就算不论前驱是否是0
				dp[i] += dp[i - 1] * 9;
				// 考虑和前驱合并的情况
				dp[i] += p == '*' ? prev * 15 : prev * arr[num1];
			} else if (p == '*') {
				// 当前数字不为*，前驱为*的情况
				if (num == 0) {
					// 如果当前为0，就只能和前驱合并
					// 前驱是 *,当前是0,可以是10，也可以是20
					dp[i] += prev * 2;
				} else {
					// 可以单个
					dp[i] += dp[i - 1];
					// 可以合并
					// 合并的时候，如果小于7，有两个选择
					dp[i] += prev * arr1[num];
				}
			} else {
				// 当前数字不为 *，前驱也不为*的情况
				if (num == 0) {
					// 只能合并的情况
					if (num1 == 1 || num1 == 2) {
						dp[i] += prev;
					}
				} else {
					dp[i] += dp[i - 1];
					// 考虑前驱
					if (num1 == 1 || (num1 == 2 && num <= 6)) {
						dp[i] += prev;
					}
				}
			}
			dp[i] %= mod;

		}
		return (int) dp[n - 1];
	}
}