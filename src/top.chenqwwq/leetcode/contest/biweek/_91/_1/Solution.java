package top.chenqwwq.leetcode.contest.biweek._91._1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author chenqwwq
 * @date 2022/11/14
 **/
public class Solution {
    public int distinctAverages(int[] nums) {
        final int n = nums.length;
        int ans = 0;
        Set<Double> exist = new HashSet<>();
        Arrays.sort(nums);
        for (int l = 0, r = n - 1; l < r; l++, r--) {
            double avg = (0d + nums[l] + nums[r]) / 2d;
            if(exist.contains(avg)) continue;;
            exist.add(avg);
            ans++;
        }
        return ans;
    }
}