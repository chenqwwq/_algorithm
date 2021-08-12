package top.chenqwwq.leetcode.lcof._2021._64;

/**
 * 剑指 Offer 64. 求1+2+…+n
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: n = 3
 * 输出: 6
 * 示例 2：
 * <p>
 * 输入: n = 9
 * 输出: 45
 * <p>
 * <p>
 * 限制：
 * <p>
 * 1 <= n <= 10000
 *
 * @author chen
 * @date 2021-08-12
 **/
public class Solution {
	public int sumNums(int n) {
		// 用短路特性代替 if 判断
		boolean ignore = n >= 1 && (1 == (n += sumNums(n - 1)));
		return n;
	}
}