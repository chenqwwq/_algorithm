package top.chenqwwq.leetcode.topic.math._268;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 示例 1:
 * <p>
 * 输入: [3,0,1]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 *
 * @author chen
 * @date 2020/6/27 下午10:00
 */
class SolutionTest {
    Solution solution = new Solution();

    @Test
    void missingNumber() {
        Assertions.assertEquals(2, solution.missingNumber(new int[]{3, 0, 1}));
        Assertions.assertEquals(8, solution.missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
    }
}