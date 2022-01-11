package top.chenqwwq.leetcode.topic.dp._1043;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author chen
 * @date 2021/5/22
 **/
class SolutionTest {

	Solution solution = new Solution();

	@Test
	void maxSumAfterPartitioning() {
		Assertions.assertEquals(84, solution.maxSumAfterPartitioning(new int[]{1, 15, 7, 9, 2, 5, 10}, 3));
		Assertions.assertEquals(83, solution.maxSumAfterPartitioning(new int[]{1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3}, 4));
		Assertions.assertEquals(1, solution.maxSumAfterPartitioning(new int[]{1}, 1));
	}
}