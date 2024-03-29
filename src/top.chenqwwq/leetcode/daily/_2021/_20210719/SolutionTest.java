package top.chenqwwq.leetcode.daily._2021._20210719;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021/7/19
 **/
class SolutionTest {

	@Test
	void maxFrequency() {
		Solution solution = new Solution();
		Assertions.assertEquals(3, solution.maxFrequency(new int[]{1, 2, 4}, 5));
		Assertions.assertEquals(2, solution.maxFrequency(new int[]{1, 4, 8, 13}, 5));
		Assertions.assertEquals(1, solution.maxFrequency(new int[]{3, 9, 6}, 2));
		Assertions.assertEquals(82, solution.maxFrequency(new int[]{9926, 9960, 10000, 9992, 9917, 9986, 9934, 9985, 9977, 9950, 9922, 9913, 9971, 9978, 9984, 9959, 9934, 9948, 9918, 9916, 9967, 9965, 9985, 9977, 9988, 9983, 9900, 9945, 9913, 9966, 9968, 9986, 9939, 9914, 9980, 9957, 9921, 9927, 9917, 9972, 9974, 9953, 9984, 9912, 9975, 9920, 9966, 9932, 9921, 9904, 9928, 9959, 9993, 9937, 9934, 9974, 9937, 9964, 9922, 9963, 9991, 9930, 9944, 9930, 9982, 9980, 9967, 9904, 9955, 9947, 9924, 9973, 9997, 9950, 9905, 9924, 9990, 9947, 9953, 9924, 9977, 9938, 9951, 9982, 9932, 9926, 9928, 9912, 9917, 9929, 9924, 9921, 9987, 9910, 9927, 9921, 9929, 9937, 9919, 9995, 9949, 9953},
				3044));
	}
}