package top.chenqwwq.leetcode.daily._2021._20210804;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021-08-04
 **/
class SolutionTest {

	@Test
	void triangleNumber() {
		Solution solution = new Solution();
		Assertions.assertEquals(3, solution.triangleNumber(new int[]{2, 2, 3, 4}));
		Assertions.assertEquals(4, solution.triangleNumber(new int[]{4, 2, 3, 4}));
	}
}