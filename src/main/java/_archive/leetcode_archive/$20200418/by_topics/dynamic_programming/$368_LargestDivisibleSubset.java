package top.chenqwwq.leetcode.archive.$20200418.by_topics.dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 368. 最大整除子集
 * <p>
 * 给出一个由无重复的正整数组成的集合，找出其中最大的整除子集，子集中任意一对 (Si，Sj) 都要满足：Si % Sj = 0 或 Sj % Si = 0。
 * <p>
 * 如果有多个目标子集，返回其中任何一个均可。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: [1,2] (当然, [1,3] 也正确)
 * 示例 2:
 * <p>
 * 输入: [1,2,4,8]
 * 输出: [1,2,4,8]
 *
 * @author bingxin.chen
 * @date 2019/12/27 15:33
 */
public class $368_LargestDivisibleSubset {
    public static void main(String[] args) {
        System.out.println(new $368_LargestDivisibleSubset().new Solution().largestDivisibleSubset(new int[]{3, 4, 16, 8}));
    }

    class Solution {
        public List<Integer> largestDivisibleSubset(int[] nums) {
            List<Integer> res = new ArrayList<>();
            if (nums == null || nums.length == 0) {
                return res;
            }

            if (nums.length == 1) {
                return new ArrayList<Integer>() {{
                    add(nums[0]);
                }};
            }

            // 先排序,保证使用较大数除以最小数
            Arrays.sort(nums);

            // 整除子集按从小到大排列,只需要最大的数字能整除,
            // 比他小的数字肯定也能整除
            // dp[i]表示(0,i)的最大整除子集长度
            int[] dp = new int[nums.length];
            // path[i]表示从小到大排列的上一个数字下标
            int[] path = new int[nums.length];

            dp[0] = 1;
            int maxLen = 1, start = 0;
            for (int i = 1; i < nums.length; i++) {
                int max = 0, index = i;
                // 从i-1反向遍历到0
                for (int j = i - 1; j >= 0; j--) {
                    if (nums[i] % nums[j] == 0) {
                        if (dp[j] + 1 > max) {
                            max = dp[j];
                            index = j;
                        }
                    }
                }

                dp[i] = max + 1;
                path[i] = index;

                if (dp[i] > maxLen) {
                    maxLen = dp[i];
                    start = i;
                }
            }

            int curr = start;
            while (path[curr] != curr) {
                res.add(nums[curr]);
                curr = path[curr];
            }
            res.add(nums[curr]);

            return res;
        }
    }
}
