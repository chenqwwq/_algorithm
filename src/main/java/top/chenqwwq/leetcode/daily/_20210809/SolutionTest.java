package top.chenqwwq.leetcode.daily._20210809;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021-08-09
 **/
class SolutionTest {

	@Test
	void nthSuperUglyNumber() {
		/**
		 * Input: n = 12, primes = [2,7,13,19]
		 * Output: 32
		 * Explanation: [1,2,4,7,8,13,14,16,19,26,28,32] is the sequence of the first 12 super ugly numbers given primes = [2,7,13,19].
		 * Example 2:
		 * <p>
		 * Input: n = 1, primes = [2,3,5]
		 * Output: 1
		 * Explanation: 1 has no prime factors, therefore all of its prime factors are in the array primes = [2,3,5].
		 */
		Solution solution = new Solution();

		Assertions.assertEquals(32, solution.nthSuperUglyNumber(12, new int[]{2, 7, 13, 19}));
		Assertions.assertEquals(1, solution.nthSuperUglyNumber(1, new int[]{2, 3, 5}));

	}
}