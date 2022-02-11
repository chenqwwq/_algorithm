package top.chenqwwq.leetcode.lcof._2021._31;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021-07-14
 **/
class SolutionTest {

	@Test
	void validateStackSequences() {
		/**
		 * 示例 1：
		 * <p>
		 * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
		 * 输出：true
		 * 解释：我们可以按以下顺序执行：
		 * push(1), push(2), push(3), push(4), pop() -> 4,
		 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
		 * 示例 2：
		 * <p>
		 * 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
		 * 输出：false
		 */

		Solution solution = new Solution();
		Assertions.assertTrue(solution.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}));
		Assertions.assertFalse(solution.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2}));
	}
}