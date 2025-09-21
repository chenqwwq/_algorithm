package top.chenqwwq.leetcode.contest.weekly._395._1;

import java.util.Arrays;

/**
 * @author chenqwwq
 * @date 2024/5/4
 **/
public class Solution {
    public int addedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        return nums2[0] - nums1[0];
    }
}