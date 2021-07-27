package top.chenqwwq.leetcode.daily._20210723;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021-07-23
 **/
class SolutionTest {

	@Test
	void isCovered() {
		Solution solution = new Solution();
		Assertions.assertTrue(solution.isCovered(new int[][]{{1, 50}}, 1, 50));
	}
}