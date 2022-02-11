package top.chenqwwq.leetcode.daily._20210831;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [[1,2,10],[2,3,20],[2,5,25]]
 * 5
 * [[1,2,10],[2,2,15]]
 * 2
 *
 * @author chen
 * @date 2021-08-31
 **/
class SolutionTest {

	@Test
	void corpFlightBookings() {
		Solution solution = new Solution();
		Assertions.assertArrayEquals(new int[]{10, 55, 45, 25, 25}, solution.corpFlightBookings(new int[][]{
				{1, 2, 10},
				{2, 3, 20},
				{2, 5, 25}
		}, 5));
	}
}