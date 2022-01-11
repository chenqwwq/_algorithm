package top.chenqwwq.leetcode.daily._20210612;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author chen
 * @date 2021/6/12
 **/
class SolutionTest {

	Solution solution = new Solution();

	@Test
	void largestNumber() {
		Assertions.assertEquals("777777771", solution.largestNumber(new int[]{4,7,3,3,8,7,3,6,5}, 28));
		Assertions.assertEquals("7772", solution.largestNumber(new int[]{4, 3, 2, 5, 6, 7, 2, 5, 5}, 9));
		Assertions.assertEquals("0", solution.largestNumber(new int[]{2, 4, 6, 2, 4, 6, 4, 4, 4}, 5));
		Assertions.assertEquals("32211", solution.largestNumber(new int[]{6, 10, 15, 40, 40, 40, 40, 40, 40}, 47));
		Assertions.assertEquals("85", solution.largestNumber(new int[]{7, 6, 5, 5, 5, 6, 8, 7, 8}, 12));
	}
}