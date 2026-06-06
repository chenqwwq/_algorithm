package top.chenqwwq.leetcode.archive.lcof._2021._66;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021-08-12
 **/
class SolutionTest {

	@Test
	void constructArr() {
		Solution solution = new Solution();
		Assertions.assertArrayEquals(new int[]{120, 60, 40, 30, 24}, solution.constructArr(new int[]{1, 2, 3, 4, 5}));
	}
}