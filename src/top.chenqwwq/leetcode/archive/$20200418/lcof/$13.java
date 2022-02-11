package top.chenqwwq.leetcode.archive.$20200418.lcof;

/**
 * 面试题13. 机器人的运动范围
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 1：
 * <p>
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * 提示：
 * <p>
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 *
 * @author chen
 * @date 2020/3/6 下午3:19
 */
public class $13 {
    class Solution {
        public int movingCount(int m, int n, int k) {
            // 应该还是dfs
            return dfs(new boolean[m][n], 0, 0, k);
        }

        public int dfs(boolean[][] isVisit, int i, int j, int k) {
            // 访问过 或者坐标范围不对 直接退出
            if (i < 0 || i >= isVisit.length || j < 0 || j >= isVisit[0].length || isVisit[i][j] || !check(i, j, k)) {
                return 0;
            }

            isVisit[i][j] = true;
            final int i1 = 1 + dfs(isVisit, i + 1, j, k) + dfs(isVisit, i - 1, j, k) + dfs(isVisit, i, j - 1, k) + dfs(isVisit, i, j + 1, k);
            return i1;

        }

        public boolean check(int i, int j, int k) {
            // i,j的范围在[0:100]
            // 取i，j的各位数字相加
            return getNumSum(i) + getNumSum(j) <= k;
        }

        public int getNumSum(int i) {
            // 主要获取各位数字的和
            final int i1 = i / 100;
            final int i2 = i / 10;
            final int i3 = i % 10;
            return i2 + i3 - 9 * i1;
        }
    }
}
