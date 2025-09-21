package top.chenqwwq.leetcode.archive.$20200418.common;

import java.util.HashSet;
import java.util.Set;

/**
 * 219. Contains Duplicate II
 * 是否有i,j符合nums[i] == num[j] && Math.abs(i - j) <= K
 *
 * @author chen
 * @date 19-7-10 下午10:48
 */
public class LeetCode219 {

    class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
//            // 暴力,线性搜索
//            for (int i = 0; i < nums.length; i++) {
//                for (int j = 1; j <= k && i + j < nums.length; j++) {
//                    if (nums[i] == nums[i + j]) {
//                        return true;
//                    }
//                }
//            }
//            return false;

            // 用了最蠢的办法,改用HashSet
            Set<Integer> set = new HashSet<>(nums.length);
            for (int i = 0; i < nums.length; i++) {
                if (set.contains(nums[i])) {
                    return true;
                }

                set.add(nums[i]);

                // 从左往右遍历,如果发现i - 0 > k,就从0开始删除
                if (i > k) {
                    set.remove(nums[i - k]);
                }
            }
            return false;
        }
    }
}
