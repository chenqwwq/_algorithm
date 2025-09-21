package top.chenqwwq.leetcode.daily._2021._20210808;

/**
 * 1137. 第 N 个泰波那契数
 * 泰波那契序列 Tn 定义如下：
 * <p>
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 * <p>
 * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4
 * 输出：4
 * 解释：
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 * 示例 2：
 * <p>
 * 输入：n = 25
 * 输出：1389537
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 37
 * 答案保证是一个 32 位整数，即 answer <= 2^31 - 1。
 *
 * @author chen
 * @date 2021/8/8
 **/
public class Solution {
	public int tribonacci(int n) {
		if (n == 0) {
			return 0;
		}
		if (n < 3) {
			return 1;
		}
		int q = 0, w = 1, e = 1, i = 3;
		while (i <= n) {
			int t = q + w + e;
			q = w;
			w = e;
			e = t;
			i++;
		}
		return e;
	}
}