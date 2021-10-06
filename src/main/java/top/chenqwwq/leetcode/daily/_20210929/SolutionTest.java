package top.chenqwwq.leetcode.daily._20210929;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

	@Test
	void findMinMoves() {
		Solution solution = new Solution();
		Assertions.assertEquals(2,solution.findMinMoves(new int[]{0,3,0}));
	}
}