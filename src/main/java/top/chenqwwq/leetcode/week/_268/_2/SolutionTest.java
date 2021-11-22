package top.chenqwwq.leetcode.week._268._2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021/11/21
 **/
class SolutionTest {

	@Test
	void wateringPlants() {
		Solution solution = new Solution();
		Assertions.assertEquals(14, solution.wateringPlants(new int[]{2, 2, 3, 3}, 5));
	}
}