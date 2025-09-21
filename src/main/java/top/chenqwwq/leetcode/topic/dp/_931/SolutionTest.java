package top.chenqwwq.leetcode.topic.dp._931;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021-05-24
 **/
class SolutionTest {

	Solution solution = new Solution();

	@Test
	void minFallingPathSum() {
		Assertions.assertEquals(13, solution.minFallingPathSum(new int[][]{
				{2, 1, 3}, {6, 5, 4}, {7, 8, 9}
		}));
		Assertions.assertEquals(-59, solution.minFallingPathSum(new int[][]{
				{-19, 57}, {-40, -5}
		}));
		Assertions.assertEquals(-48, solution.minFallingPathSum(new int[][]{
				{-48}
		}));
	}
}