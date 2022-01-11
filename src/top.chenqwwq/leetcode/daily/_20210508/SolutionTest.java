package top.chenqwwq.leetcode.daily._20210508;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021-05-08
 **/
class SolutionTest {

	/**
	 * Example 1:
	 * <p>
	 * Input: jobs = [3,2,3], k = 3
	 * Output: 3
	 * Explanation: By assigning each person one job, the maximum time is 3.
	 * Example 2:
	 * <p>
	 * Input: jobs = [1,2,4,7,8], k = 2
	 * Output: 11
	 * Explanation: Assign the jobs the following way:
	 * Worker 1: 1, 2, 8 (working time = 1 + 2 + 8 = 11)
	 * Worker 2: 4, 7 (working time = 4 + 7 = 11)
	 * The maximum working time is 11.
	 * <p>
	 * [9899456,8291115,9477657,9288480,5146275,7697968,8573153,3582365,3758448,9881935,2420271,4542202]
	 * 9
	 */

	Solution solution = new Solution();

	@Test
	void minimumTimeRequired() {
		Assertions.assertEquals(9899456, solution.minimumTimeRequired(new int[]{9899456, 8291115, 9477657, 9288480, 5146275, 7697968, 8573153, 3582365, 3758448, 9881935, 2420271, 4542202}, 9));
		Assertions.assertEquals(3, solution.minimumTimeRequired(new int[]{3, 2, 3}, 3));
		Assertions.assertEquals(11, solution.minimumTimeRequired(new int[]{1, 2, 4, 7, 8}, 2));
	}
}