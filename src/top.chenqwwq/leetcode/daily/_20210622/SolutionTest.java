package top.chenqwwq.leetcode.daily._20210622;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

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