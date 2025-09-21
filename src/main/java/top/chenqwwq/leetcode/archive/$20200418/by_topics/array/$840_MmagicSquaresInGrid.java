package top.chenqwwq.leetcode.archive.$20200418.by_topics.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 840. 矩阵中的幻方
 * <p>
 * 3 x 3 的幻方是一个填充有从 1 到 9 的不同数字的 3 x 3 矩阵，其中每行，每列以及两条对角线上的各数之和都相等。
 * <p>
 * 给定一个由整数组成的 grid，其中有多少个 3 × 3 的 “幻方” 子矩阵？（每个子矩阵都是连续的）。
 * <p>
 * 示例：
 * <p>
 * 输入: [[4,3,8,4],
 * [9,5,1,9],
 * [2,7,6,2]]
 * 输出: 1
 * 解释:
 * 下面的子矩阵是一个 3 x 3 的幻方：
 * 438
 * 951
 * 276
 * <p>
 * 而这一个不是：
 * 384
 * 519
 * 762
 * <p>
 * 总的来说，在本示例所给定的矩阵中只有一个 3 x 3 的幻方子矩阵。
 * 提示:
 * <p>
 * 1 <= grid.length <= 10
 * 1 <= grid[0].length <= 10
 * 0 <= grid[i][j] <= 15
 *
 * @author chen
 * @date 2019/12/21 下午4:26
 */
public class $840_MmagicSquaresInGrid {
    /**
     * 8 1 6   8 3 4   6 1 8   6 7 2
     * 3 5 7   1 5 9   7 5 3   1 5 9
     * 4 9 2   6 7 2   2 9 4   8 3 4
     * <p>
     * 4 9 2   4 3 8   2 9 4   2 7 6
     * 3 5 7   9 5 1   7 5 3   9 5 1
     * 8 1 6   2 7 6   6 1 8   4 3 8
     * <p>
     * 作者：hareyukai
     * 链接：https://leetcode-cn.com/problems/magic-squares-in-grid/solution/-ju-zhen-zhong-de-huan-fang-by-hareyukai/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * <p>
     * 中心全部为5
     */
    class Solution {

        private final int SUM = 15;

        private final Set<Long> SET = new HashSet<>(Arrays.asList(816357492L, 834159672L, 618753294L, 672159834L,
                492357816L, 438951276L, 294753618L, 276951438L));

        public int numMagicSquaresInside(int[][] grid) {
            // 以3 * 3的中心作为遍历
            // 验证三横三竖
            int res = 0;
            for (int i = 1; i < grid.length - 1; i++) {
                for (int j = 1; j < grid[0].length - 1; j++) {
                    if (grid[i][j] != 5) {
                        continue;
                    }
                    long temp = 0;
                    for (int p = -1; p <= 1; p++) {
                        for (int q = -1; q <= 1; q++) {
                            temp = temp * 10 + grid[i + p][j + q];
                        }
                    }
                    if (SET.contains(temp)) {
                        res++;
                    }
                }
            }

            return res;
        }
    }
}
