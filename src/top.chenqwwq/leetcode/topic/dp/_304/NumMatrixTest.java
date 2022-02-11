package top.chenqwwq.leetcode.topic.dp._304;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021/5/29
 **/
class NumMatrixTest {

	NumMatrix numMatrix = new NumMatrix(new int[][]{
			{3, 0, 1, 4, 2},
			{5, 6, 3, 2, 1},
			{1, 2, 0, 1, 5},
			{4, 1, 0, 1, 7},
			{1, 0, 3, 0, 5}
	});

	@Test
	void sumRegion() {
		Assertions.assertEquals(8, numMatrix.sumRegion(2, 1, 4, 3));
		Assertions.assertEquals(11, numMatrix.sumRegion(1, 1, 2, 2));
		Assertions.assertEquals(12, numMatrix.sumRegion(1, 2, 2, 4));
	}
}