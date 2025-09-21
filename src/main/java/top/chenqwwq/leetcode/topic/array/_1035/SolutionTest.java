package top.chenqwwq.leetcode.topic.array._1035;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author chen
 * @date 2021/5/12
 **/
class SolutionTest {

	/**
	 * Example 1:
	 * <p>
	 * <p>
	 * Input: A = [1,4,2], B = [1,2,4]
	 * Output: 2
	 * Explanation: We can draw 2 uncrossed lines as in the diagram.
	 * We cannot draw 3 uncrossed lines, because the line from A[1]=4 to B[2]=4 will intersect the line from A[2]=2 to B[1]=2.
	 * Example 2:
	 * <p>
	 * Input: A = [2,5,1,2,5], B = [10,5,2,1,5,2]
	 * Output: 3
	 * Example 3:
	 * <p>
	 * Input: A = [1,3,7,1,7,5], B = [1,9,2,5,1]
	 * Output: 2
	 * <p>
	 */

	Solution solution = new Solution();

	@Test
	void maxUncrossedLines() {
		assertEquals(2, solution.maxUncrossedLines(new int[]{1, 4, 2}, new int[]{1, 2, 4}));
		assertEquals(3, solution.maxUncrossedLines(new int[]{2,5,1,2,5}, new int[]{10,5,2,1,5,2}));
		assertEquals(2, solution.maxUncrossedLines(new int[]{1,3,7,1,7,5}, new int[]{1,9,2,5,1}));
	}
}