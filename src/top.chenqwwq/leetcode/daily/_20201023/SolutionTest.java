package top.chenqwwq.leetcode.daily._20201023;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import top.chenqwwq.leetcode.common.ListNode;

/**
 * @author chen
 * @date 2020-10-23
 **/
class SolutionTest {


    Solution solution = new Solution();

    @Test
    void isPalindrome() {
        Assertions.assertTrue(solution.isPalindrome(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(2, new ListNode(1)))))));
        Assertions.assertFalse(solution.isPalindrome(new ListNode(1, new ListNode(2))));
        Assertions.assertTrue(solution.isPalindrome(new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))))));
    }
}