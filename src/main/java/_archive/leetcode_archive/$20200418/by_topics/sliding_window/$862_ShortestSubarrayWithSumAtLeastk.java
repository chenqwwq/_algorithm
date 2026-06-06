package top.chenqwwq.leetcode.archive.$20200418.by_topics.sliding_window;

/**
 * 862. 和至少为 K 的最短子数组
 * <p>
 * 返回 A 的最短的非空连续子数组的长度，该子数组的和至少为 K 。
 * <p>
 * 如果没有和至少为 K 的非空子数组，返回 -1 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [1], K = 1
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：A = [1,2], K = 4
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：A = [2,-1,2], K = 3
 * 输出：3
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 50000
 * -10 ^ 5 <= A[i] <= 10 ^ 5
 * 1 <= K <= 10 ^ 9
 *
 * @author chen
 * @date 2019/12/21 下午9:56
 */
public class $862_ShortestSubarrayWithSumAtLeastk {

    public static void main(String[] args) {
//        System.out.println(new $862_ShortestSubarrayWithSumAtLeastk().new Solution().shortestSubarray(new int[]{2,-1,2},3));
//        System.out.println(new $862_ShortestSubarrayWithSumAtLeastk().new Solution().shortestSubarray(new int[]{1,2},4));
//        System.out.println(new $862_ShortestSubarrayWithSumAtLeastk().new Solution().shortestSubarray(new int[]{84,-37,32,40,95},167));
//        System.out.println(new $862_ShortestSubarrayWithSumAtLeastk().new Solution().shortestSubarray(new int[]{48,99,37,4,-31},140));
        System.out.println(new $862_ShortestSubarrayWithSumAtLeastk().new Solution().shortestSubarray(new int[]{-34, 37, 51, 3, -12, -50, 51, 100, -47, 99, 34, 14, -13, 89, 31, -14, -44, 23, -38, 6}, 151));
    }

    class Solution {
        public int shortestSubarray(int[] A, int K) {
            // 滑动窗口
            int left = 0, right = 0, currSum = A[0], res = Integer.MAX_VALUE;

            while (left <= right) {
                // 小于则另外增加
                if (currSum < K) {
                    // 如果收缩会让当前和变大,优先收缩
                    if (A[left] < 0 && left < right) {
                        currSum -= A[left++];
                        continue;
                    }
                    // 窗口扩大
                    if (right + 1 < A.length) {
                        currSum += A[++right];
                    } else {
                        return res == Integer.MAX_VALUE ? -1 : res;
                    }

                } else {
                    if (currSum >= K) {
                        res = Math.min(right - left + 1, res);
                    }
                    currSum -= A[left++];
                }
            }

            return res == Integer.MAX_VALUE ? -1 : res;
        }
    }
}
