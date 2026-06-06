package top.chenqwwq.leetcode.topic.backtrack._486;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author chen
 * @date 2021/5/21
 **/
class SolutionTest {

	Solution solution = new Solution();

	@Test
	void predictTheWinner() {
		Assertions.assertFalse(solution.PredictTheWinner(new int[]{1, 5, 2}));
		Assertions.assertTrue(solution.PredictTheWinner(new int[]{1, 5, 233, 7}));
	}
}