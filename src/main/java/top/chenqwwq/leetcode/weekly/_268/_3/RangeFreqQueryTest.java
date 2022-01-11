package top.chenqwwq.leetcode.weekly._268._3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021/11/21
 **/
class RangeFreqQueryTest {

	@Test
	void query() {
		RangeFreqQuery solution = new RangeFreqQuery(new int[]{12,33,4,56,22,2,34,33,22,12,34,56});
		Assertions.assertEquals(1,solution.query(1,2,4));
		Assertions.assertEquals(2,solution.query(0,11,33));

	}

}