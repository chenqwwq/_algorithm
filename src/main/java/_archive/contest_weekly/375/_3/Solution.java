package top.chenqwwq.leetcode.contest.weekly._375._3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author chenqwwq
 * @date 2023/12/10
 **/
public class Solution {
    public long countSubarrays(int[] nums, int k) {
        int mx = 0;
        for (int x : nums) {
            mx = Math.max(mx, x);
        }

        long ans = 0;
        int cntMx = 0, left = 0;
        for (int x : nums) {
            if (x == mx) {
                cntMx++;
            }
            while (cntMx == k) {
                if (nums[left++] == mx) {
                    cntMx--;
                }
            }
            ans += left;
        }
        return ans;
    }
}