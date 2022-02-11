package top.chenqwwq.leetcode.weekly._254._3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021/8/15
 **/
class SolutionTest {

	@Test
	void minNonZeroProduct() {
		Solution solution = new Solution();
		Assertions.assertEquals(505517599, solution.minNonZeroProduct(32));
		Assertions.assertEquals(1512, solution.minNonZeroProduct(3));
		Assertions.assertEquals(581202553, solution.minNonZeroProduct(4));
		Assertions.assertEquals(202795991, solution.minNonZeroProduct(5));
		Assertions.assertEquals(513022074, solution.minNonZeroProduct(25));
		Assertions.assertEquals(945196305, solution.minNonZeroProduct(30));
		Assertions.assertEquals(1, solution.minNonZeroProduct(1));
		Assertions.assertEquals(6, solution.minNonZeroProduct(2));
		Assertions.assertEquals(138191773, solution.minNonZeroProduct(31));
	}

}