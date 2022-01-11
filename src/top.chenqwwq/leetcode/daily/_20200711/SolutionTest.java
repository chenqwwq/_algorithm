package top.chenqwwq.leetcode.daily._20200711;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 示例:
 * <p>
 * 输入: [5,2,6,1]
 * 输出: [2,1,1,0]
 * 解释:
 * 5 的右侧有 2 个更小的元素 (2 和 1).
 * 2 的右侧仅有 1 个更小的元素 (1).
 * 6 的右侧有 1 个更小的元素 (1).
 * 1 的右侧有 0 个更小的元素.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chen
 * @date 2020/7/11 下午9:59
 */
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void countSmaller() {
        Assertions.assertArrayEquals(new Integer[]{2, 1, 1, 0}, solution.countSmaller(new int[]{5, 2, 6, 1}).toArray());
    }


}