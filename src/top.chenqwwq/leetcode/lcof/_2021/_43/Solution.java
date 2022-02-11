package top.chenqwwq.leetcode.lcof._2021._43;

/**
 * 剑指 Offer 43. 1～n 整数中 1 出现的次数
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 * <p>
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 12
 * 输出：5
 * 示例 2：
 * <p>
 * 输入：n = 13
 * 输出：6
 * <p>
 * <p>
 * 限制：
 * <p>
 * 1 <= n < 2^31
 *
 * @author chen
 * @date 2021/5/26
 **/
public class Solution {
	public int countDigitOne(int n) {
		int ans = 0, level = 10;
		while (level <= 10 * n) {
			int base = level / 10;
			int left = n / level, right = n % level, curr = right / base;
			if (curr == 0) {
				ans += left * base;
			} else if (curr == 1) {
				ans += (left * base + right + 1);
			} else {
				ans += (left + 1) * base;
			}
			level *= 10;
		}
		return ans;
	}
}