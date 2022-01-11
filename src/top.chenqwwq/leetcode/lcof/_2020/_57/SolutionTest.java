package top.chenqwwq.leetcode.lcof._2020._57;

import org.junit.jupiter.api.Test;
import top.chenqwwq.leetcode.utils.ArrayUtils;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 示例 1：
 * <p>
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 * 示例 2：
 * <p>
 * 输入：nums = [10,26,30,31,47,60], target = 40
 * 输出：[10,30] 或者 [30,10]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * l
 *
 * @author chen
 * @date 2020-06-30
 **/
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void twoSum() {
        assertTrue(ArrayUtils.arrEqual(new int[]{2, 7}, solution.twoSum(new int[]{2, 7, 11, 15}, 9)));
        assertTrue(ArrayUtils.arrEqual(new int[]{10, 30}, solution.twoSum(new int[]{10, 26, 30, 31, 47, 60}, 40)));
    }
}