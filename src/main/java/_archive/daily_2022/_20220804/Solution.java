package top.chenqwwq.leetcode.daily._2022._20220804;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenqwwq
 * @date 2022/8/
 **/
public class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        List<Integer> ans = new ArrayList<>();
        int cur = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            ans.add(nums[i]);
            cur += nums[i];
            if (sum - cur < cur) {
                break;
            }
        }
        return ans;
    }
}