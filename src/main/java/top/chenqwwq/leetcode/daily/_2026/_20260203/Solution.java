package top.chenqwwq.leetcode.daily._2026._20260203;

/**
 * @author chenqwwq
 * @date 2026/2/3
 **/
public class Solution {
    public boolean isTrionic(int[] nums) {
        final int n = nums.length;
        int i = 0;
        while (i + 1 < n && nums[i] <= nums[i + 1]) i++;

        int j = n - 1;
        while (j - 1 >= 0 && nums[j - 1] <= nums[j]) j--;

        // [1,3,5,4,2,6]

        for (int k = i; k < j; k++) {
            if (nums[k] <= nums[k + 1]) return false;
        }
        return true;
    }
}