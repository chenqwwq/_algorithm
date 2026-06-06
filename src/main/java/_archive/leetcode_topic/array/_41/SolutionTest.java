package top.chenqwwq.leetcode.topic.array._41;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 示例 1:
 * <p>
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 * <p>
 * 输入: [7,8,9,11,12]
 * 输出: 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-missing-positive
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chen
 * @date 2020/6/27 下午11:10
 */
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void firstMissingPositive() {
        Assertions.assertEquals(2, solution.firstMissingPositive(new int[]{1}));
        Assertions.assertEquals(2, solution.firstMissingPositive(new int[]{1, 1}));
        Assertions.assertEquals(5, solution.firstMissingPositive(new int[]{1, 2, 3, 4}));
        Assertions.assertEquals(3, solution.firstMissingPositive(new int[]{1, 2, 0}));
        Assertions.assertEquals(2, solution.firstMissingPositive(new int[]{3, 4, -1, 1}));
        Assertions.assertEquals(1, solution.firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
    }
}