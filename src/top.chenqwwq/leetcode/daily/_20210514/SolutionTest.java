package top.chenqwwq.leetcode.daily._20210514;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021-05-14
 **/
class SolutionTest {

	/**
	 * 示例 1:
	 * <p>
	 * 输入: num = 3
	 * 输出: "III"
	 * 示例 2:
	 * <p>
	 * 输入: num = 4
	 * 输出: "IV"
	 * 示例 3:
	 * <p>
	 * 输入: num = 9
	 * 输出: "IX"
	 * 示例 4:
	 * <p>
	 * 输入: num = 58
	 * 输出: "LVIII"
	 * 解释: L = 50, V = 5, III = 3.
	 * 示例 5:
	 * <p>
	 * 输入: num = 1994
	 * 输出: "MCMXCIV"
	 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
	 */

	Solution solution = new Solution();

	@Test
	void intToRoman() {
		Assertions.assertEquals("III", solution.intToRoman(3));
		Assertions.assertEquals("IV", solution.intToRoman(4));
		Assertions.assertEquals("IX", solution.intToRoman(9));
		Assertions.assertEquals("LVIII", solution.intToRoman(58));
		Assertions.assertEquals("MCMXCIV", solution.intToRoman(1994));
		Assertions.assertEquals("MMMCMXCIX", solution.intToRoman(3999));
	}
}