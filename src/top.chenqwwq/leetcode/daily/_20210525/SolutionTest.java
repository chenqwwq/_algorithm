package top.chenqwwq.leetcode.daily._20210525;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021-05-25
 **/
class SolutionTest {

	Solution solution = new Solution();

	@Test
	void minChanges() {
		Assertions.assertEquals(3, solution.minChanges(new int[]{1, 2, 0, 3, 0}, 1));
		Assertions.assertEquals(3, solution.minChanges(new int[]{3, 4, 5, 2, 1, 7, 3, 4, 7}, 3));
		Assertions.assertEquals(3, solution.minChanges(new int[]{1, 2, 4, 1, 2, 5, 1, 2, 6}, 3));
	}
}