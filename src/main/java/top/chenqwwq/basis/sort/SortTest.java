package top.chenqwwq.basis.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021-09-18
 **/
class SortTest {

	@Test
	void testSortAes() {
		int[] ints = {10, 8, 2, 5, 7, 3, 9, 6, 1, 4};
		new MergeSort().sortAes(ints);
		Assertions.assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, ints);
	}
}