package top.chenqwwq.leetcode.lcof._2021._67;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * <p>
 * 输入: "42"
 * 输出: 42
 * 示例 2:
 * <p>
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 * 我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * 示例 3:
 * <p>
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 * 示例 4:
 * <p>
 * 输入: "words and 987"
 * 输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 * 因此无法执行有效的转换。
 * 示例 5:
 * <p>
 * 输入: "-91283472332"
 * 输出: -2147483648
 *
 * @author chen
 * @date 2021-08-12
 **/
class SolutionTest {

	@Test
	void strToInt() {
		Solution solution = new Solution();


		Assertions.assertEquals(2147483647, solution.strToInt("9223372036854775808"));
		Assertions.assertEquals(0, solution.strToInt("   +0 123"));
		Assertions.assertEquals(-42, solution.strToInt("   -42"));
		Assertions.assertEquals(42, solution.strToInt("42"));
		Assertions.assertEquals(4193, solution.strToInt("4193 with words"));
		Assertions.assertEquals(0, solution.strToInt("words and 987"));
		Assertions.assertEquals(-2147483648, solution.strToInt("-91283472332"));
	}
}