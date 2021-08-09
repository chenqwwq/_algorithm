package top.chenqwwq.leetcode.daily._20210807;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021/8/7
 **/
class SolutionTest {

	@Test
	void circularArrayLoop() {
		Solution solution = new Solution();
		Assertions.assertTrue(solution.circularArrayLoop(new int[]{2, -1, 1, 2, 2}));
		Assertions.assertFalse(solution.circularArrayLoop(new int[]{-2, 1, -1, -2, -2}));
		Assertions.assertFalse(solution.circularArrayLoop(new int[]{-1, 2}));
	}

}