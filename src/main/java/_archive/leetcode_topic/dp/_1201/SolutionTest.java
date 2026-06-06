package top.chenqwwq.leetcode.topic.dp._1201;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021-08-09
 **/
class SolutionTest {

	@Test
	void nthUglyNumber() {
		Solution solution = new Solution();
		Assertions.assertEquals(10, solution.nthUglyNumber(5, 2, 11, 13));
		Assertions.assertEquals(4, solution.nthUglyNumber(3, 2, 3, 5));
		Assertions.assertEquals(6, solution.nthUglyNumber(4, 2, 3, 4));
		Assertions.assertEquals(1999999984, solution.nthUglyNumber(1000000000, 2, 217983653, 336916467));
	}
}