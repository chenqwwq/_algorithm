package top.chenqwwq.leetcode.topic.array._1471;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021-05-24
 **/
class SolutionTest {

	Solution solution = new Solution();

	@Test
	void getStrongest() {
		Assertions.assertArrayEquals(new int[]{517}, solution.getStrongest(new int[]{517}, 1));
		Assertions.assertArrayEquals(new int[]{5, 1}, solution.getStrongest(new int[]{1, 2, 3, 4, 5}, 2));
		Assertions.assertArrayEquals(new int[]{5, 5}, solution.getStrongest(new int[]{1, 1, 3, 5, 5}, 2));
		Assertions.assertArrayEquals(new int[]{11, 8, 6, 6, 7}, solution.getStrongest(new int[]{6, 7, 11, 7, 6, 8}, 5));
		Assertions.assertArrayEquals(new int[]{-3, 11, 2}, solution.getStrongest(new int[]{6, -3, 7, 2, 11}, 3));
		Assertions.assertArrayEquals(new int[]{22, 17}, solution.getStrongest(new int[]{-7, 22, 17, 3}, 2));
	}
}