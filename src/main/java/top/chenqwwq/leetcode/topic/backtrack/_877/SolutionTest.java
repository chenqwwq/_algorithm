package top.chenqwwq.leetcode.topic.backtrack._877;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021/5/21
 **/
class SolutionTest {

	Solution solution = new Solution();

	@Test
	void stoneGame() {
		Assertions.assertTrue(solution.stoneGame(new int[]{5, 3, 4, 5}));
	}
}