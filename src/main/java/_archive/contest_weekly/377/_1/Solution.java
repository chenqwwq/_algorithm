package top.chenqwwq.leetcode.contest.weekly._377._1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author chenqwwq
 * @date 2023/12/24
 **/
public class Solution {
    public int[] numberGame(int[] nums) {
        final int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; i += 2) {
            int t = nums[i];
            nums[i] = nums[i + 1];
            nums[i+1] = t;
        }
        return nums;
    }
}