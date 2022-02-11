package top.chenqwwq.leetcode.daily._20210701;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021/7/1
 **/
class SolutionTest {

	@Test
	void numWays() {
		Solution solution = new Solution();
		final int[][] relation = {
				{0, 2}, {2, 1}, {3, 4}, {2, 3}, {1, 4}, {2, 0}, {0, 4}
		};
		Assertions.assertEquals(3, solution.numWays(5, relation, 3));
	}

}