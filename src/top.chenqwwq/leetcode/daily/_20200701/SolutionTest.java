package top.chenqwwq.leetcode.daily._20200701;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 示例 1:
 * <p>
 * 输入:
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出: 3
 * 解释:
 * 长度最长的公共子数组是 [3, 2, 1]。
 *
 * @author chen
 * @date 2020-07-01
 **/
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void findLength() {
        Assertions.assertEquals(3, solution.findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
    }
}