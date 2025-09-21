package top.chenqwwq.leetcode.contest.weekly._296._2;

import java.util.Arrays;

/**
 * @author chenqwwq
 * @date 2022/6/5
 **/
public class Solution {
    public int partitionArray(int[] nums, int k) {
        final int n = nums.length;
        Arrays.sort(nums);
        int l = 0, r = 0;
        int ans = 1;
        while (r < n) {
            while (r < n && nums[r] - nums[l] <= k) {
                r++;
            }
            ans++;
            l = r;
        }
        return ans;
    }

}