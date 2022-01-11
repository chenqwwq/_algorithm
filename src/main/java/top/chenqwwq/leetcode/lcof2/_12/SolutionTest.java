package top.chenqwwq.leetcode.lcof2._12;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author chenbingxin
 * @date 2021/12/10
 **/
class SolutionTest {

	@Test
	void pivotIndex() {
		Solution solution = new Solution();
		Assertions.assertEquals(3,solution.pivotIndex(new int[]{1,7,3,6,5,6}));
		Assertions.assertEquals(-1,solution.pivotIndex(new int[]{1,2,3}));
		Assertions.assertEquals(0,solution.pivotIndex(new int[]{2,1,-1}));
	}
}