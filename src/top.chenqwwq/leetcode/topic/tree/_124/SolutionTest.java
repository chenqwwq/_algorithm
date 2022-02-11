package top.chenqwwq.leetcode.topic.tree._124;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import top.chenqwwq.leetcode.common.TreeNode;

/**
 * @author chen
 * @date 2021-05-20
 **/
class SolutionTest {


	Solution solution = new Solution();

	@Test
	void maxPathSum() {
		Assertions.assertEquals(42, solution.maxPathSum(new TreeNode(-1, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
	}
}