package top.chenqwwq.leetcode.daily._20210627;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021/6/27
 **/
class SolutionTest {

	@Test
	void snakesAndLadders() {
		Solution solution = new Solution();
		Assertions.assertEquals(1, solution.snakesAndLadders(new int[][]{
				{-1, 7, -1}, {-1, 6, 9}, {-1, -1, 2}
		}));
		Assertions.assertEquals(4, solution.snakesAndLadders(new int[][]{
				{-1, -1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1, -1},
				{-1, 35, -1, -1, 13, -1},
				{-1, -1, -1, -1, -1, -1},
				{-1, 15, -1, -1, -1, -1}
		}));
		Assertions.assertEquals(1, solution.snakesAndLadders(new int[][]{
				{-1, -1, -1},
				{-1, 9, 8},
				{-1, 8, 9}
		}));
	}
}