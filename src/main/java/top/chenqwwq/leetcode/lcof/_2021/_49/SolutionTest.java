package top.chenqwwq.leetcode.lcof._2021._49;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021-08-09
 **/
class SolutionTest {

	@Test
	void nthUglyNumber() {
		final Solution solution = new Solution();
		Assertions.assertEquals(15, solution.nthUglyNumber(11));
		Assertions.assertEquals(16, solution.nthUglyNumber(12));
		Assertions.assertEquals(18, solution.nthUglyNumber(13));
		Assertions.assertEquals(20, solution.nthUglyNumber(14));
		Assertions.assertEquals(24, solution.nthUglyNumber(15));
		Assertions.assertEquals(25, solution.nthUglyNumber(16));
		Assertions.assertEquals(27, solution.nthUglyNumber(17));
		Assertions.assertEquals(30, solution.nthUglyNumber(18));
		Assertions.assertEquals(12, solution.nthUglyNumber(10));
	}
}