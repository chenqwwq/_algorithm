package top.chenqwwq.leetcode.daily._20200628;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 示例:
 * <p>
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 *
 * @author chen
 * @date 2020/6/28 上午12:02
 */
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void minSubArrayLen() {
        Assertions.assertEquals(2, solution.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        Assertions.assertEquals(0, solution.minSubArrayLen(3, new int[]{1, 1}));
    }
}