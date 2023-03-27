package top.chenqwwq.leetcode.daily._2021._20210523;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021/5/23
 **/
class SolutionTest {

	Solution solution = new Solution();

	@Test
	void maximizeXor() {
		Assertions./**/assertArrayEquals(new int[]{3, 3, 7}, solution.maximizeXor(new int[]{0, 1, 2, 3, 4}, new int[][]{{3, 1}, {1, 3}, {5, 6}}));
		Assertions.assertArrayEquals(new int[]{15, -1, 5}, solution.maximizeXor(new int[]{5, 2, 4, 6, 6, 3}, new int[][]{{12, 4}, {8, 1}, {6, 3}}));
		Assertions.assertArrayEquals(new int[]{911525976, 942531152, 942478738, 903088400, 865553375}, solution.maximizeXor(new int[]{184496090, 438054009, 3188, 940991508, 218709965}, new int[][]{{742974497, 791461635}, {3900996, 1000000000}, {3895686, 1000000000}, {801645929, 785619328}, {193015755, 1000000000}}));
		final int[] ints = {0, 3090096, 4194304, 845573555, 0, 778971744, 267447, 0, 4194304, 4194304, 446819176, 45001354, 4194304, 3777171, 873518539, 0, 1165390, 4194304, 3372544, 0};
		Assertions.assertArrayEquals(new int[]{877712843, 1054448840, 983690088, 1004194304, 670287232, 539961008, 1004194304, 895625239, 1004194304, 877712843, 536870912, 1010039618, 581872266, 877712843, 541065216, 1019056103, 7971475, 1004194304, 877712843, 1004194304},
				solution.maximizeXor(ints,
						new int[][]{{4194304, 1000000000}, {280475304, 1000000000}, {536870912, 1000000000}, {1000000000, 1000000000}, {668787504, 391894850}, {536870912, 3143980}, {1000000000, 619304916}, {453771895, 1000000000}, {1000000000, 1000000000}, {4194304, 1000000000}, {536870912, 66331}, {308138274, 1000000000}, {536870912, 240619799}, {4194304, 1000000000}, {536870912, 4194304}, {315860359, 1000000000}, {4194304, 4194304}, {1000000000, 1000000000}, {4194304, 1000000000}, {1000000000, 994164423}
						}));
	}
}