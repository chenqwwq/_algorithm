package top.chenqwwq.leetcode.daily._20200716;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 示例 1:
 * 输入: [[1,3], [0,2], [1,3], [0,2]]
 * 输出: true
 * 解释:
 * 无向图如下:
 * 0----1
 * |    |
 * |    |
 * 3----2
 * 我们可以将节点分成两组: {0, 2} 和 {1, 3}。
 * <p>
 * 示例 2:
 * 输入: [[1,2,3], [0,2], [0,1,3], [0,2]]
 * 输出: false
 * 解释:
 * 无向图如下:
 * 0----1
 * | \  |
 * |  \ |
 * 3----2
 * 我们不能将节点分割成两个独立的子集。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/is-graph-bipartite
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chen
 * @date 2020/7/16 下午10:05
 */
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void isBipartite() {
        Assertions.assertTrue(solution.isBipartite(new int[][]{
                {1, 3},
                {0, 2},
                {1, 3},
                {0, 2}
        }));

        Assertions.assertFalse(solution.isBipartite(new int[][]{
                {1, 2, 3},
                {0, 2},
                {0, 1, 3},
                {0, 2}
        }));

        Assertions.assertTrue(solution.isBipartite(new int[][]{
                {1},
                {0, 3},
                {3},
                {1, 2}
        }));
    }
}