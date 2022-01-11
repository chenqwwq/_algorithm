package top.chenqwwq.leetcode.daily._20210617;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021/6/17
 **/
class SolutionTest {

	@Test
	void isNumber() {
		Assertions.assertFalse(new Solution().isNumber("4e+"));
		Assertions.assertTrue(new Solution().isNumber("-0.1"));
		Assertions.assertTrue(new Solution().isNumber(".1"));
		Assertions.assertTrue(new Solution().isNumber("0089"));
		Assertions.assertTrue(new Solution().isNumber("2"));
		Assertions.assertTrue(new Solution().isNumber("+3.14"));
		Assertions.assertTrue(new Solution().isNumber("-.9"));
		Assertions.assertTrue(new Solution().isNumber("2e10"));
		Assertions.assertTrue(new Solution().isNumber("-90E3"));
		Assertions.assertTrue(new Solution().isNumber("3e+7"));
		Assertions.assertTrue(new Solution().isNumber("+6e-1"));
		Assertions.assertTrue(new Solution().isNumber("53.5e93"));
		Assertions.assertTrue(new Solution().isNumber("-123.456e789"));
	}
}