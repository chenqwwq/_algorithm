package top.chenqwwq.leetcode.archive.$20200418.daily;

import java.util.ArrayList;

/**
 * 面试题57 - II. 和为s的连续正数序列
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * <p>
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 * <p>
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 * <p>
 * 限制：
 * <p>
 * 1 <= target <= 10^5
 *
 * @author chen
 * @date 2020/3/6 下午3:07
 */
public class $0006 {
    class Solution {
        public int[][] findContinuousSequence(int target) {
            ArrayList<int[]> res = new ArrayList<>();
            int l = 1, r = 1, sum = 1;
            final int border = (target / 2) + 1;
            do {
                if (sum == target) {
                    int[] arr = new int[r - l + 1];
                    for (int i = l; i <= r; i++) {
                        arr[i - l] = i;
                    }
                    res.add(arr);
                }

                if (sum > target) {
                    sum -= l++;
                } else {
                    sum += ++r;
                }
            } while (l < r && r <= border);

            return res.toArray(new int[0][]);
        }
    }
}
