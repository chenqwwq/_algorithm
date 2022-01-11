package top.chenqwwq.leetcode.weekly._246._2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021/6/20
 **/
class SolutionTest {

	Solution solution = new Solution();

	@Test
	void numberOfRounds() {
		Assertions.assertEquals(88, solution.numberOfRounds("02:00", "01:00"));
	}
}