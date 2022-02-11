package top.chenqwwq.leetcode.biweek._30._2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,4], n = 4, left = 1, right = 5
 * 输出：13
 * 解释：所有的子数组和为 1, 3, 6, 10, 2, 5, 9, 3, 7, 4 。将它们升序排序后，我们得到新的数组 [1, 2, 3, 3, 4, 5, 6, 7, 9, 10] 。下标从 le = 1 到 ri = 5 的和为 1 + 2 + 3 + 3 + 4 = 13 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4], n = 4, left = 3, right = 4
 * 输出：6
 * 解释：给定数组与示例 1 一样，所以新数组为 [1, 2, 3, 3, 4, 5, 6, 7, 9, 10] 。下标从 le = 3 到 ri = 4 的和为 3 + 3 = 6 。
 * 示例 3：
 * <p>
 * 输入：nums = [1,2,3,4], n = 4, left = 1, right = 10
 * 输出：50
 *
 * @author chen
 * @date 2020/7/11 下午11:01
 */
class SolutionTest {
    Solution solution = new Solution();

    @Test
    void rangeSum() {
        Assertions.assertEquals(13, solution.rangeSum(new int[]{1, 2, 3, 4}, 4, 1, 5));
        Assertions.assertEquals(6, solution.rangeSum(new int[]{1, 2, 3, 4}, 4, 3, 4));
        Assertions.assertEquals(50, solution.rangeSum(new int[]{1, 2, 3, 4}, 4, 1, 10));
    }
}