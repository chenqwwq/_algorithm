package top.chenqwwq.leetcode.daily._2023._20230725;

import java.util.*;

/**
 * @author chenqwwq
 * @date 2023/7/15
 **/
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        final int n = nums.length;
        if (n < 4) return List.of();
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int a = 0; a < n; a++) {
            if (a > 0 && nums[a] == nums[a - 1]) continue;
            for (int b = a + 1; b < n; b++) {
                if (b > a + 1 && nums[b] == nums[b - 1]) continue;
                int l = b + 1, r = n - 1;
                while (l < r) {
                    final long sum = (long) nums[a] + nums[b] + nums[r] + nums[l];
                    if (sum == target) {
                        ans.add(List.of(nums[a], nums[b], nums[l], nums[r]));
                        while (++l < r && nums[l] == nums[l-1]){}
                        while (--r >l && nums[r] == nums[r+1]){}
                    } else if (sum > target) r--;
                    else l++;
                }
            }
        }
        return ans;
    }
}