package top.chenqwwq.leetcode.daily._2021._20210903;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021-09-03
 **/
class SolutionTest {

	@Test
	void smallestK() {
		Solution solution = new Solution();
		Assertions.assertArrayEquals(new int[]{1, 2, 3, 4}, solution.smallestK(new int[]{1, 3, 5, 7, 2, 4, 6, 8}, 4));
	}
}