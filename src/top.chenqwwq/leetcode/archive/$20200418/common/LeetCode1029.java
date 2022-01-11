package top.chenqwwq.leetcode.archive.$20200418.common;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1029. 两地调度
 *
 * @author chen
 * @date 19-4-21
 */
public class LeetCode1029 {
    class Solution {
        public int twoCitySchedCost(int[][] costs) {
            // 贪心算法解决： 贪心策略为差值
            // 将二维数组按照0,1差值升序排列,数值越小表示越适合在去A城市

            Arrays.sort(costs, Comparator.comparingInt(o -> o[0] - o[1]));

            int sum = 0;
            final int halfLength = costs.length / 2;
            for (int i = 0; i < costs.length; i++) {
                if (i < halfLength) {
                    sum += costs[i][0];
                } else {
                    sum += costs[i][1];
                }
            }
            return sum;
        }
    }
}
