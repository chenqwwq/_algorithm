package top.chenqwwq.leetcode.archive.$20200418.common;

import java.util.List;

/**
 * 120. 三角形最小路劲和
 * <p>
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * <p>
 * 例如，给定三角形：
 * <p>
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * <p>
 * 说明：
 * <p>
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author bingxin.chen
 * @date 2019/7/25 20:16
 */
public class LeetCode120 {
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            if (triangle.size() == 1) {
                return triangle.get(0).get(0);
            }
            final int size = triangle.get(triangle.size() - 1).size();
            int[] dp = new int[size];
            for (int i = 0; i < size; i++) {
                dp[i] = triangle.get(triangle.size() - 1).get(i);
            }
            for (int i = triangle.size() - 1; i >= 0; i--) {
                for (int j = 0; j < triangle.get(i).size(); i++) {
                    dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
                }
            }
            return dp[0];
        }
    }
}
