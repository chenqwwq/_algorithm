package top.chenqwwq.basis.dichotomy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021-07-09
 **/
class DichotomyTest {
	Dichotomy search = new Dichotomy();

	@Test
	void find1() {
		final int[] nums = {1, 2, 3, 4, 5, 6, 7};
		Assertions.assertEquals(0, search.find1(nums, 1));
		Assertions.assertEquals(-1, search.find1(nums, 0));
		Assertions.assertEquals(6, search.find1(nums, 7));
		Assertions.assertEquals(3, search.find1(nums, 4));
		Assertions.assertEquals(0, search.find1(new int[]{1}, 1));
	}

	final int[] nums = new int[]{1, 1, 1, 2, 3, 3, 3, 3, 3, 5};

	@Test
	void find2() {
		Assertions.assertEquals(nums.length - 1, search.find2(nums, 5));
		Assertions.assertEquals(-1, search.find2(nums, 6));
		Assertions.assertEquals(4, search.find2(nums, 3));
		Assertions.assertEquals(0, search.find2(nums, 1));
		Assertions.assertEquals(3, search.find2(nums, 2));
		Assertions.assertEquals(0, search.find2(new int[]{2, 2, 2}, 2));
	}

	@Test
	void find3() {
		Assertions.assertEquals(8, search.find3(nums, 3));
		Assertions.assertEquals(nums.length - 1, search.find3(nums, 5));
		Assertions.assertEquals(-1, search.find3(nums, 6));
		Assertions.assertEquals(2, search.find3(nums, 1));
		Assertions.assertEquals(3, search.find3(nums, 2));
		Assertions.assertEquals(2, search.find3(new int[]{2, 2, 2}, 2));
	}
}