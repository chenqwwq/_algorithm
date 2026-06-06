package top.chenqwwq.leetcode.topic.recursion._1137;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021-05-26
 **/
class SolutionTest {

	Solution solution = new Solution();

	@Test
	void tribonacci() {
		Assertions.assertEquals(4, solution.tribonacci(4));
		Assertions.assertEquals(1389537, solution.tribonacci(25));
	}
}