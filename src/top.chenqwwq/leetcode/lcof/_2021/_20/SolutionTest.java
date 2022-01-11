package top.chenqwwq.leetcode.lcof._2021._20;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021-06-23
 **/
class SolutionTest {

	/**
	 * 示例 1：
	 * <p>
	 * 输入：s = "0"
	 * 输出：true
	 * 示例 2：
	 * <p>
	 * 输入：s = "e"
	 * 输出：false
	 * 示例 3：
	 * <p>
	 * 输入：s = "."
	 * 输出：false
	 * 示例 4：
	 * <p>
	 * 输入：s = "    .1  "
	 * 输出：true
	 * <p>
	 * <p>
	 * * <p>
	 * * ["+100", "5e2", "-123", "3.1416", "-1E-16", "0123"]
	 * * 部分非数值列举如下：
	 * * <p>
	 * * ["12e", "1a3.14", "1.2.3", "+-5", "12e+5.4"]
	 * * <
	 */


	Solution solution = new Solution();

	@Test
	void isNumber() {

		Assertions.assertFalse(solution.isNumber("-."));
		Assertions.assertTrue(solution.isNumber("3."));

		Assertions.assertFalse(solution.isNumber("12e"));
		Assertions.assertFalse(solution.isNumber("1a3.14"));
		Assertions.assertFalse(solution.isNumber("1.2.3"));
		Assertions.assertFalse(solution.isNumber("+-5"));
		Assertions.assertFalse(solution.isNumber("12e+5.4"));

		Assertions.assertTrue(solution.isNumber("3.1416"));
		Assertions.assertTrue(solution.isNumber("-1E-16"));
		Assertions.assertTrue(solution.isNumber("0123"));
		Assertions.assertTrue(solution.isNumber("0"));
		Assertions.assertFalse(solution.isNumber("e"));
		Assertions.assertFalse(solution.isNumber("."));
		Assertions.assertTrue(solution.isNumber("    .1  "));
		Assertions.assertTrue(solution.isNumber("+100"));
		Assertions.assertTrue(solution.isNumber("5e2"));
		Assertions.assertTrue(solution.isNumber("-1230"));

		Assertions.assertTrue(solution.isNumber("+.8"));
		Assertions.assertFalse(solution.isNumber(".-4"));
		Assertions.assertFalse(solution.isNumber("4e+"));
	}
}