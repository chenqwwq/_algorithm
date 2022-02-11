package top.chenqwwq.leetcode.lcof._2020._60;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import top.chenqwwq.leetcode.utils.ArrayUtils;

/**
 * 示例 1:
 * <p>
 * 输入: 1
 * 输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
 * 示例 2:
 * <p>
 * 输入: 2
 * 输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chen
 * @date 2020-07-03
 **/
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void twoSum() {
//        Assertions.assertTrue(ArrayUtils.arrEqual(new double[]{0.16667, 0.16667, 0.16667, 0.16667, 0.16667, 0.16667}, solution.twoSum(1)));
        Assertions.assertTrue(ArrayUtils.arrEqual(new double[]{0.02778, 0.05556, 0.08333, 0.11111, 0.13889, 0.16667, 0.13889, 0.11111, 0.08333, 0.05556, 0.02778}, solution.twoSum(2)));
    }
}