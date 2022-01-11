package top.chenqwwq.leetcode.lcof._2020._29;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import top.chenqwwq.leetcode.utils.ArrayUtils;

/**
 * 示例 1：
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 * <p>
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chen
 * @date 2020-07-03
 **/
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void spiralOrder() {
        Assertions.assertTrue(ArrayUtils.arrEqual(new int[]{1, 2, 3, 6, 9, 8, 7, 4, 5}, solution.spiralOrder(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        })));

        Assertions.assertTrue(ArrayUtils.arrEqual(new int[]{1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7}, solution.spiralOrder(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        })));
        Assertions.assertTrue(ArrayUtils.arrEqual(new int[]{7, 9, 6}, solution.spiralOrder(new int[][]{
                {7},
                {9},
                {6}
        })));
    }
}