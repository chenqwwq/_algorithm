package top.chenqwwq.leetcode.daily._20210815;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021/8/15
 **/
class SolutionTest {

	@Test
	void findPaths() {
		Solution solution = new Solution();
		Assertions.assertEquals(12, solution.findPaths(1, 3, 3, 0, 1));
	}

}