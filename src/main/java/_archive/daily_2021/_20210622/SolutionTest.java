package top.chenqwwq.leetcode.daily._2021._20210622;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author chen
 * @date 2021-06-22
 **/
class SolutionTest {

	@Test
	void permutation() {
		final String[] abcs = new Solution().permutation("aab");
		System.out.println(Arrays.toString(abcs));
	}
}