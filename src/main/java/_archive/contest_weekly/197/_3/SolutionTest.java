package top.chenqwwq.leetcode.contest.weekly._197._3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 输入：n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.2], start = 0, end = 2
 * 输出：0.25000
 * 解释：从起点到终点有两条路径，其中一条的成功概率为 0.2 ，而另一条为 0.5 * 0.5 = 0.25
 * <p>
 * n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.3], start = 0, end = 2
 * 输出：0.30000
 * <p>
 * 输入：n = 3, edges = [[0,1]], succProb = [0.5], start = 0, end = 2
 * 输出：0.00000
 * 解释：节点 0 和 节点 2 之间不存在路径
 *
 * @author chen
 * @date 2020/7/12 上午11:54
 */
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void maxProbability() {
        Assertions.assertEquals(0.25d, new Solution().maxProbability(3, new int[][]{{0, 1}, {1, 2}, {0, 2}}, new double[]{0.5d, 0.5d, 0.2d}, 0, 2));
        Assertions.assertEquals(0.30d, new Solution().maxProbability(3, new int[][]{{0, 1}, {1, 2}, {0, 2}}, new double[]{0.5d, 0.5d, 0.3d}, 0, 2));
        Assertions.assertEquals(0.000, new Solution().maxProbability(3, new int[][]{{0, 1}}, new double[]{0.5}, 0, 2));
    }
}