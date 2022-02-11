package top.chenqwwq.leetcode.weekly._267._2;

import org.junit.jupiter.api.Test;
import top.chenqwwq.leetcode.common.ListNode;

/**
 * @author chen
 * @date 2021/11/17
 **/
class SolutionTest {

	@Test
	void reverseEvenLengthGroups() {
		Solution solution = new Solution();
		solution.reverseEvenLengthGroups(ListNode.build(new int[]{0, 4, 2, 1, 3}));
		solution.reverseEvenLengthGroups(ListNode.build(new int[]{5, 2, 6, 3, 9, 1, 7, 3, 8, 4}));
	}
}