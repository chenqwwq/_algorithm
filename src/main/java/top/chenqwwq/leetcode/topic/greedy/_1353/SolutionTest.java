package top.chenqwwq.leetcode.topic.greedy._1353;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021-05-17
 **/
class SolutionTest {

	/**
	 * Example 1:
	 * <p>
	 * <p>
	 * Input: events = [[1,2],[2,3],[3,4]]
	 * Output: 3
	 * Explanation: You can attend all the three events.
	 * One way to attend them all is as shown.
	 * Attend the first event on day 1.
	 * Attend the second event on day 2.
	 * Attend the third event on day 3.
	 * Example 2:
	 * <p>
	 * Input: events= [[1,2],[2,3],[3,4],[1,2]]
	 * Output: 4
	 * Example 3:
	 * <p>
	 * Input: events = [[1,4],[4,4],[2,2],[3,4],[1,1]]
	 * Output: 4
	 * Example 4:
	 * <p>
	 * Input: events = [[1,100000]]
	 * Output: 1
	 * Example 5:
	 * <p>
	 * Input: events = [[1,1],[1,2],[1,3],[1,4],[1,5],[1,6],[1,7]]
	 * Output: 7
	 */

	Solution solution = new Solution();

	@Test
	void maxEvents() {
		Assertions.assertEquals(3, solution.maxEvents(new int[][]{
				{1, 2},
				{2, 3},
				{3, 4}
		}));
		Assertions.assertEquals(4, solution.maxEvents(new int[][]{
				{1, 2},
				{2, 3},
				{3, 4},
				{1, 2},
		}));
		Assertions.assertEquals(4, solution.maxEvents(new int[][]{
				{1, 4},
				{4, 4},
				{2, 2},
				{3, 4},
				{1, 1}
		}));
		Assertions.assertEquals(1, solution.maxEvents(new int[][]{
				{1, 100000}
		}));
		Assertions.assertEquals(7, solution.maxEvents(new int[][]{
				{1, 1},
				{1, 2},
				{1, 3},
				{1, 4},
				{1, 5},
				{1, 6},
				{1, 7}
		}));
	}
}