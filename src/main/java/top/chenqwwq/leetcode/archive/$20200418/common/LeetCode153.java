package top.chenqwwq.leetcode.archive.$20200418.common;

/**
 * @author chen
 * @description
 * @email ai654778@vip.qq.com
 * @date 19-2-3
 */
public class LeetCode153 {
    static class Solution {
        public int findMin(int[] nums) {
            int sArr = 0, eArr = nums.length - 1;

            while (eArr > sArr) {
                int midArr = (eArr + sArr) / 2;
                // 用中间元素和首元素对比
                if (nums[midArr] < nums[sArr]) {
                    // 中间元素小于
                    eArr = midArr;
                } else {
                    sArr = midArr + 1;
                }
            }
            return nums[sArr];
        }
    }
}
