package top.chenqwwq.leetcode.daily._20210920;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author chen
 * @date 2021/9/20
 **/
class SolutionTest {

	@Test
	void findNumberOfLIS() {
		Solution solution = new Solution();
		Assertions.assertEquals(5,solution.findNumberOfLIS(new int[]{2,2,2,2,2}));
		Assertions.assertEquals(3,solution.findNumberOfLIS(new int[]{1,2,4,3,5,4,7,2}));
		Assertions.assertEquals(2,solution.findNumberOfLIS(new int[]{1,3,5,4,7}));
	}
}