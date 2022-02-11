package top.chenqwwq.leetcode.daily._20210512;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021-05-12
 **/
class SolutionTest {

	/**
	 * 示例 1：
	 * <p>
	 * 输入：arr = [1,3,4,8], queries = [[0,1],[1,2],[0,3],[3,3]]
	 * 输出：[2,7,14,8]
	 * 解释：
	 * 数组中元素的二进制表示形式是：
	 * 1 = 0001
	 * 3 = 0011
	 * 4 = 0100
	 * 8 = 1000
	 * 查询的 XOR 值为：
	 * [0,1] = 1 xor 3 = 2
	 * [1,2] = 3 xor 4 = 7
	 * [0,3] = 1 xor 3 xor 4 xor 8 = 14
	 * [3,3] = 8
	 * 示例 2：
	 * <p>
	 * 输入：arr = [4,8,2,10], queries = [[2,3],[1,3],[0,0],[0,3]]
	 * 输出：[8,0,4,4]
	 */

	Solution solution = new Solution();

	@Test
	void xorQueries() {
		Assertions.assertArrayEquals(new int[]{2, 7, 14, 8}, solution.xorQueries(new int[]{1, 3, 4, 8}, new int[][]{
				{0, 1}, {1, 2}, {0, 3}, {3, 3}
		}));
		Assertions.assertArrayEquals(new int[]{8, 0, 4, 4}, solution.xorQueries(new int[]{4, 8, 2, 10}, new int[][]{
				{2, 3}, {1, 3}, {0, 0}, {0, 3}
		}));
	}
}