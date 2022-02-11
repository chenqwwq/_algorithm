package top.chenqwwq.leetcode.daily._20210805;

import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021-08-05
 **/
class SolutionTest {

	@Test
	void eventualSafeNodes() {
		Solution solution = new Solution();
		System.out.println(solution.eventualSafeNodes(new int[][]{
				{1, 2}, {2, 3}, {5}, {2}, {5}, {}, {}
		}));
	}
}