package top.chenqwwq.leetcode.topic.array._287;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2020/6/27 下午10:42
 */
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void findDuplicate() {
        Assertions.assertEquals(2, solution.findDuplicate(new int[]{1, 3, 4, 2, 2}));
        Assertions.assertEquals(3, solution.findDuplicate(new int[]{3, 1, 3, 4, 2}));
    }
}