package top.chenqwwq.leetcode.daily._20210529;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author chen
 * @date 2021/5/29
 **/
class SolutionTest {

	Solution solution = new Solution();

	@Test
	void numSubmatrixSumTarget() {

		Assertions.assertEquals(5, solution.numSubmatrixSumTarget(new int[][]{
				{1, -1}, {-1, 1}
		}, 0));

		Assertions.assertEquals(0, solution.numSubmatrixSumTarget(new int[][]{
				{904}
		}, 0));

		Assertions.assertEquals(4, solution.numSubmatrixSumTarget(new int[][]{
				{0, 1, 0}, {1, 1, 1}, {0, 1, 0}
		}, 0));
	}
}