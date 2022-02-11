package top.chenqwwq.leetcode.lcof._2021._43;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021/7/17
 **/
class SolutionTest {

	@Test
	void countDigitOne() {
		Solution solution = new Solution();
		Assertions.assertEquals(5, solution.countDigitOne(12));
		Assertions.assertEquals(6, solution.countDigitOne(13));
		Assertions.assertEquals(35, solution.countDigitOne(109));
		Assertions.assertEquals(1, solution.countDigitOne(9));
	}
}