package top.chenqwwq.leetcode.topic.dichotomy._29;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021-09-15
 **/
class SolutionTest {

	@Test
	void divide() {
		Solution solution = new Solution();
		Assertions.assertEquals(3, solution.divide(10, 3));
		Assertions.assertEquals(-2, solution.divide(7, -3));
	}
}