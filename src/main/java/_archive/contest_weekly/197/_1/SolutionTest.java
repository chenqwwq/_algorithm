package top.chenqwwq.leetcode.contest.weekly._197._1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,1,1,3]
 * 输出：4
 * 解释：有 4 组好数对，分别是 (0,3), (0,4), (3,4), (2,5) ，下标从 0 开始
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,1,1]
 * 输出：6
 * 解释：数组中的每组数字都是好数对
 * 示例 3：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：0
 *
 * @author chen
 * @date 2020/7/12 上午10:33
 */
class SolutionTest {
    Solution solution = new Solution();

    @Test
    void numIdenticalPairs() {
        Assertions.assertEquals(4, solution.numIdenticalPairs(new int[]{1, 2, 3, 1, 1, 3}));
        Assertions.assertEquals(6, solution.numIdenticalPairs(new int[]{1, 1, 1, 1}));
        Assertions.assertEquals(0, solution.numIdenticalPairs(new int[]{1, 2, 3}));
    }
}