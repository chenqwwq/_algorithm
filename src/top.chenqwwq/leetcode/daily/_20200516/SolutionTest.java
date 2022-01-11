package top.chenqwwq.leetcode.daily._20200516;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import top.chenqwwq.leetcode.utils.ListUtils;

/**
 * @author chen
 * @date 2020/5/16 下午3:53
 */
class SolutionTest {

    private Solution solution;


    {
        solution = new Solution();
    }

    @Test
    void reverseKGroup() {
//        ListNode list = solution.reverseKGroup(ListUtils.getList(5), 2);
        Assertions.assertTrue(ListUtils.compareLinkedList(solution.reverseKGroup(ListUtils.getList(5), 2), new int[]{2, 1, 4, 3, 5}));
        solution.clean();

        Assertions.assertTrue(ListUtils.compareLinkedList(solution.reverseKGroup(ListUtils.getList(5), 3), new int[]{3, 2, 1, 4, 5}));
        solution.clean();

        Assertions.assertTrue(ListUtils.compareLinkedList(solution.reverseKGroup(ListUtils.getList(2), 2), new int[]{2, 1}));
        solution.clean();

    }


}