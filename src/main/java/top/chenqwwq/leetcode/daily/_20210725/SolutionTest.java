package top.chenqwwq.leetcode.daily._20210725;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021/7/25
 **/
class SolutionTest {

	@Test
	void restoreArray() {
		Solution solution = new Solution();
		Assertions.assertArrayEquals(new int[]{1, 2, 3, 4}, solution.restoreArray(new int[][]{
				{2, 1}, {3, 4}, {3, 2}
		}));
	}
}