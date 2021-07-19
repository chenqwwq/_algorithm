package top.chenqwwq.leetcode.lcof._2021._65;

/**
 * 剑指 Offer 65. 不用加减乘除做加法
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入: a = 1, b = 1
 * 输出: 2
 * <p>
 * <p>
 * 提示：
 * <p>
 * a, b 均可能是负数或 0
 * 结果不会溢出 32 位整数
 *
 * @author chen
 * @date 2021-07-19
 **/
public class Solution {
	public int add(int a, int b) {
		while (b != 0){
			int t = (a & b) << 1;
			a ^= b;
			b = t;
		}
		return a;
	}
}