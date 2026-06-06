package top.chenqwwq.leetcode.contest.biweek._66._2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chenbingxin
 * @date 2021/11/28
 **/
class SolutionTest {

	@Test
	public void testSolution() {
		Solution solution = new Solution();
		Assertions.assertEquals(2, solution.minimumBuckets("H..H"));
		Assertions.assertEquals(1, solution.minimumBuckets(".H.H."));
		Assertions.assertEquals(-1, solution.minimumBuckets(".HHH."));
		Assertions.assertEquals(-1, solution.minimumBuckets("H"));
		Assertions.assertEquals(0, solution.minimumBuckets("."));
		Assertions.assertEquals(3, solution.minimumBuckets(".HH.H.H.H.."));
	}

}