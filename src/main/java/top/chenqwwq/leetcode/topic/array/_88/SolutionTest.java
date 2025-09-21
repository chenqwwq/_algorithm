package top.chenqwwq.leetcode.topic.array._88;

import org.junit.jupiter.api.Test;
import top.chenqwwq.leetcode.utils.ArrayUtils;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author chen
 * @date 2020/6/13 下午3:00
 */
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void merge() {
        int[] want = {1, 2, 2, 3, 5, 6};
        int[] num1 = {1, 2, 3, 0, 0, 0};
        solution.merge(num1, 3, new int[]{2, 5, 6}, 3);
        assertTrue(ArrayUtils.arrEqual(want, num1));

        int[] num2 = {2, 0};
        solution.merge(num2, 1, new int[]{1}, 1);

        assertTrue(ArrayUtils.arrEqual(num2, new int[]{1, 2}));
    }
}