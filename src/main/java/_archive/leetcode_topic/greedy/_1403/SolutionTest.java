package top.chenqwwq.leetcode.topic.greedy._1403;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import top.chenqwwq.leetcode.utils.ListUtils;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author chen
 * @date 2020/10/24
 **/
class SolutionTest {
    /**
     * 示例 1：
     * <p>
     * 输入：nums = [4,3,10,9,8]
     * 输出：[10,9]
     * 解释：子序列 [10,9] 和 [10,8] 是最小的、满足元素之和大于其他各元素之和的子序列。但是 [10,9] 的元素之和最大。
     * 示例 2：
     * <p>
     * 输入：nums = [4,4,7,6,7]
     * 输出：[7,7,6]
     * 解释：子序列 [7,7] 的和为 14 ，不严格大于剩下的其他元素之和（14 = 4 + 4 + 6）。因此，[7,6,7] 是满足题意的最小子序列。注意，元素按非递增顺序返回。
     * 示例 3：
     * <p>
     * 输入：nums = [6]
     * 输出：[6]
     * <p>
     */

    Solution solution = new Solution();

    @Test
    void minSubsequence() {
        Assertions.assertTrue(ListUtils.compare(Arrays.stream(new int[]{10, 9}).boxed().collect(Collectors.toList()), solution.minSubsequence(new int[]{4, 3, 10, 9, 8})));
        Assertions.assertTrue(ListUtils.compare(Arrays.stream(new int[]{7, 7, 6}).boxed().collect(Collectors.toList()), solution.minSubsequence(new int[]{4, 4, 7, 6, 7})));
        Assertions.assertTrue(ListUtils.compare(Arrays.stream(new int[]{6}).boxed().collect(Collectors.toList()), solution.minSubsequence(new int[]{6})));
    }
}