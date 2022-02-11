package top.chenqwwq.leetcode.daily._20210712;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021/7/12
 **/
class SolutionTest {

	Solution solution = new Solution();

	@Test
	void hIndex() {
		Assertions.assertEquals(3, solution.hIndex(new int[]{0, 1, 3, 5, 6}));
	}
}