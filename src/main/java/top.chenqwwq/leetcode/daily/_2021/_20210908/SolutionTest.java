package top.chenqwwq.leetcode.daily._2021._20210908;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021/9/8
 **/
class SolutionTest {

	@Test
	void findMaximizedCapital() {
		Solution solution = new Solution();
		Assertions.assertEquals(4, solution.findMaximizedCapital(2, 0, new int[]{1, 2, 3}, new int[]{0, 1, 1}));
	}

}