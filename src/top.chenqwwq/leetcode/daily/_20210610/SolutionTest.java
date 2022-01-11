package top.chenqwwq.leetcode.daily._20210610;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021-06-10
 **/
class SolutionTest {

	Solution solution = new Solution();

	@Test
	void change() {
		Assertions.assertEquals(4, solution.change(5, new int[]{1, 2, 5}));
	}
}