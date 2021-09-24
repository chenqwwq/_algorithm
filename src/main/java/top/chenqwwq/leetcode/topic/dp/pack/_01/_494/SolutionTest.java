package top.chenqwwq.leetcode.topic.dp.pack._01._494;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021/9/11
 **/
class SolutionTest {

	@Test
	void findTargetSumWays() {
		Solution solution = new Solution();
		Assertions.assertEquals(1048576, solution.findTargetSumWays(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, 0));
		Assertions.assertEquals(5, solution.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
	}
}