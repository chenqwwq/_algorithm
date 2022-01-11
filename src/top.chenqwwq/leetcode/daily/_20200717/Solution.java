package top.chenqwwq.leetcode.daily._20200717;

/**
 * 35. 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 *
 * @author chen
 * @date 2020-07-17
 **/
public class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0 || nums[0] > target) {
            return 0;
        }
        if (nums[nums.length - 1] < target) {
            return nums.length;
        }

        final int length = nums.length;
        int start = 0, end = length - 1;
        int ans = nums.length;

        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            if (nums[mid] > target) {
                ans = mid;
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                return mid;
            }
        }

        return ans;
    }
}