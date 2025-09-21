package top.chenqwwq.leetcode.archive.lcof._2021._54;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import top.chenqwwq.leetcode.common.TreeNode;

/**
 * @author chen
 * @date 2021-07-19
 **/
class SolutionTest {

	@Test
	void kthLargest() {
		/**
		 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
		 * 5
		 * / \
		 * 3   6
		 * / \
		 * 2   4
		 * /
		 * 1
		 */

		Assertions.assertEquals(1, new Solution().kthLargest(new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), new TreeNode(4)), 4));
		Assertions.assertEquals(4, new Solution().kthLargest(new TreeNode(5, new TreeNode(3, new TreeNode(2, new TreeNode(1), null), new TreeNode(4)), new TreeNode(6)), 3));
	}
}