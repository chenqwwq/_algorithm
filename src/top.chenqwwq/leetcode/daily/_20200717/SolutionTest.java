package top.chenqwwq.leetcode.daily._20200717;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 示例 1:
 * <p>
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 * <p>
 * 输入: [1,3,5,6], 0
 * 输出: 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chen
 * @date 2020-07-17
 **/
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void searchInsert() {
        Assertions.assertEquals(2, solution.searchInsert(new int[]{1, 3, 5, 6}, 5));
        Assertions.assertEquals(1, solution.searchInsert(new int[]{1, 3, 5, 6}, 2));
        Assertions.assertEquals(0, solution.searchInsert(new int[]{1, 3, 5, 6}, 0));
        Assertions.assertEquals(4, solution.searchInsert(new int[]{1, 3, 5, 6}, 7));
    }
}