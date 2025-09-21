package top.chenqwwq.leetcode.topic.backtrack._980;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021-05-21
 **/
class SolutionTest {

	@Test
	void uniquePathsIII() {
		Assertions.assertEquals(2, new Solution().uniquePathsIII(new int[][]{
				{1, 0, 0, 0},
				{0, 0, 0, 0},
				{0, 0, 2, -1}
		}));
		Assertions.assertEquals(4, new Solution().uniquePathsIII(new int[][]{
				{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 2}
		}));
		Assertions.assertEquals(0, new Solution().uniquePathsIII(new int[][]{
				{0, 1}, {2, 0}
		}));
	}
}