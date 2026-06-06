package top.chenqwwq.leetcode.topic.graph._1042;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import top.chenqwwq.leetcode.utils.ArrayUtils;

/**
 * 示例 1：
 * <p>
 * 输入：N = 3, paths = [[1,2],[2,3],[3,1]]
 * 输出：[1,2,3]
 * 示例 2：
 * <p>
 * 输入：N = 4, paths = [[1,2],[3,4]]
 * 输出：[1,2,1,2]
 * 示例 3：
 * <p>
 * 输入：N = 4, paths = [[1,2],[2,3],[3,4],[4,1],[1,3],[2,4]]
 * 输出：[1,2,3,4]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flower-planting-with-no-adjacent
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chen
 * @date 2020/7/4 下午10:44
 */
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void gardenNoAdj() {
        Assertions.assertTrue(ArrayUtils.arrEqual(new int[]{1, 2, 3}, solution.gardenNoAdj(3, new int[][]{
                {1, 2},
                {2, 3},
                {3, 1}
        })));
        Assertions.assertTrue(ArrayUtils.arrEqual(new int[]{1, 2, 1, 2}, solution.gardenNoAdj(4, new int[][]{
                {1, 2},
                {3, 4}
        })));
        Assertions.assertTrue(ArrayUtils.arrEqual(new int[]{1, 2, 3, 4}, solution.gardenNoAdj(4, new int[][]{
                {1, 2},
                {2, 3},
                {3, 4},
                {4, 1},
                {1, 3},
                {2, 4},
        })));
    }
}