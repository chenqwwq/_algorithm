package top.chenqwwq.leetcode.daily._20210731;

import org.junit.jupiter.api.Test;
import top.chenqwwq.leetcode.common.TreeNode;

import javax.xml.transform.Source;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author chen
 * @date 2021/7/31
 **/
class SolutionTest {

	@Test
	void verticalTraversal() {
		Solution solution = new Solution();
		solution.verticalTraversal(new TreeNode(3,new TreeNode(9),new TreeNode(20,new TreeNode(15),new TreeNode(7))));
	}
}