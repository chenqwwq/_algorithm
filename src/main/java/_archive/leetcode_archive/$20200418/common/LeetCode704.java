package top.chenqwwq.leetcode.archive.$20200418.common;

/**
 * 704. Binary Search 二分查找
 *
 * @author bingxin.chen
 * @date 2019/6/5 13:18
 */
public class LeetCode704 {

    class Solution {
        public int search(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return -1;
            }

            return binarySearch(target, 0, nums.length - 1, nums);
        }

        private int binarySearch(int target, int start, int end, int[] nums) {
            if (start > end) {
                return -1;
            }
            int resIndex = start + ((end - start) >> 1);
            if (nums[resIndex] == target) {
                return resIndex;
            }
            return target > nums[resIndex]
                    ? binarySearch(target, resIndex + 1, end, nums)
                    : binarySearch(target, start, resIndex - 1, nums);
        }
    }
}
