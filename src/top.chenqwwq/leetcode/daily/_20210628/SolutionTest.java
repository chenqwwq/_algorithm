package top.chenqwwq.leetcode.daily._20210628;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021-06-28
 **/
class SolutionTest {

	@Test
	void numBusesToDestination() {
		Solution solution = new Solution();
		Assertions.assertEquals(2, solution.numBusesToDestination(new int[][]{
				{1, 2, 7}, {3, 6, 7}
		}, 1, 6));
	}
}