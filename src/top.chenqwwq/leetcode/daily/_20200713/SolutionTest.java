package top.chenqwwq.leetcode.daily._20200713;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 示例 1:
 * <p>
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 * <p>
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chen
 * @date 2020-07-13
 **/
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void intersect() {
        Assertions.assertArrayEquals(new int[]{2, 2}, solution.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2}));
        Assertions.assertArrayEquals(new int[]{4, 9}, solution.intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}));
    }
}