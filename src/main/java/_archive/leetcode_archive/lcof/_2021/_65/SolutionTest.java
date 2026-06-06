package top.chenqwwq.leetcode.archive.lcof._2021._65;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021-07-19
 **/
class SolutionTest {

	@Test
	void add() {
		Solution solution = new Solution();
		Assertions.assertEquals(9, solution.add(3, 6));
		Assertions.assertEquals(2, solution.add(1, 1));
		Assertions.assertEquals(5, solution.add(2, 3));
		Assertions.assertEquals(3, solution.add(2, 1));
	}
}