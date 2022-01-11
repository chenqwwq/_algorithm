package top.chenqwwq.leetcode.daily._20210803;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021-08-03
 **/
class SolutionTest {

	@Test
	void findUnsortedSubarray() {
		Solution solution = new Solution();

		Assertions.assertEquals(0, solution.findUnsortedSubarray(new int[]{1, 2, 3, 4}));
		Assertions.assertEquals(3, solution.findUnsortedSubarray(new int[]{1, 2, 4, 5, 3}));
	}

}