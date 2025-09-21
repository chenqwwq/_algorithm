package top.chenqwwq.leetcode.archive.$20200418.weekly.$168;

import java.util.Map;
import java.util.TreeMap;

/**
 * 划分数组为连续数字的集合
 * <p>
 * 给你一个整数数组 nums 和一个正整数 k，请你判断是否可以把这个数组划分成一些由 k 个连续数字组成的集合。
 * 如果可以，请返回 True；否则，返回 False。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,3,4,4,5,6], k = 4
 * 输出：true
 * 解释：数组可以分成 [1,2,3,4] 和 [3,4,5,6]。
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,1,2,3,4,3,4,5,9,10,11], k = 3
 * 输出：true
 * 解释：数组可以分成 [1,2,3] , [2,3,4] , [3,4,5] 和 [9,10,11]。
 * 示例 3：
 * <p>
 * 输入：nums = [3,3,2,2,1,1], k = 3
 * 输出：true
 * 示例 4：
 * <p>
 * 输入：nums = [1,2,3,4], k = 3
 * 输出：false
 * 解释：数组不能分成几个大小为 3 的子数组。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^9
 * 1 <= k <= nums.length
 *
 * @author chen
 * @date 2019/12/22 下午4:42
 */
public class $2_DivideArrayInSetsOfKConsecutiveNumbers {
    public static void main(String[] args) {
        System.out.println(new $2_DivideArrayInSetsOfKConsecutiveNumbers().new Solution().isPossibleDivide(new int[]{3, 3, 2, 2, 1, 1}, 3));
    }

    class Solution {
        public boolean isPossibleDivide(int[] nums, int k) {
            if (nums.length % k != 0) {
                return false;
            }
            TreeMap<Integer, Integer> hash = new TreeMap<>();
            for (int num : nums) {
                hash.put(num, hash.getOrDefault(num, 0) + 1);
            }

            while (!hash.isEmpty()) {
                final Map.Entry<Integer, Integer> entry = hash.firstEntry();
                removeOrReduce(hash, entry.getKey());

                for (int i = 1; i < k; i++) {
                    int want = i + entry.getKey();
                    if (!hash.containsKey(want) || hash.get(want) == 0) {
                        return false;
                    }

                    removeOrReduce(hash, want);
                }
            }
            return true;
        }

        private void removeOrReduce(Map<Integer, Integer> map, Integer key) {
            if (!map.containsKey(key)) {
                return;
            }
            final Integer integer = map.get(key);
            if (integer == 1) {
                map.remove(key);
            } else {
                map.put(key, integer - 1);
            }
        }
    }
}
