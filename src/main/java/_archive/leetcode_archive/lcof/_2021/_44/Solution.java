package top.chenqwwq.leetcode.archive.lcof._2021._44;

/**
 * 剑指 Offer 44. 数字序列中某一位的数字
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 * <p>
 * 请写一个函数，求任意第n位对应的数字。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：n = 11
 * 输出：0
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= n < 2^31
 *
 * @author chen
 * @date 2021-07-14
 **/
public class Solution {
	public int findNthDigit(int n) {
		long w = 1, cnt = 10, start = 0;
		while (n >= w * cnt) {
			n -= (w * cnt);
			w++;
			start = (int) Math.pow(10, w - 1);
			cnt = 9 * start;
		}

		cnt = n / w;
		int remainder = (int) (n % w);

		start += cnt;

		return (int) (start / Math.pow(10, w - remainder - 1) % 10);
	}

}