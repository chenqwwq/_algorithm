package top.chenqwwq.leetcode.daily._20210626;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021/6/26
 **/
class SolutionTest {

	Solution solution = new Solution();

	@Test
	void slidingPuzzle() {
		Assertions.assertEquals(-1, solution.slidingPuzzle(new int[][]{
				{1, 2, 3}, {5, 4, 0}
		}));
	}
}