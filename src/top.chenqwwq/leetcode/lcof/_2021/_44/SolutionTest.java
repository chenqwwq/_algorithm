package top.chenqwwq.leetcode.lcof._2021._44;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021-07-20
 **/
class SolutionTest {

	@Test
	void findNthDigit() {
		Solution solution = new Solution();
		Assertions.assertEquals(1, solution.findNthDigit(10));
		Assertions.assertEquals(0, solution.findNthDigit(11));
		Assertions.assertEquals(3, solution.findNthDigit(3));
	}
}