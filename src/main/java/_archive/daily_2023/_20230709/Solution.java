package top.chenqwwq.leetcode.daily._2023._20230709;

import java.util.*;

/**
 * @author chenqwwq
 * @date 2023/7/9
 **/
public class Solution {
    Set<String> vis = new HashSet<>();

    public List<List<Integer>> threeSum(int[] nums) {
        vis.clear();
        final int n = nums.length;
        Arrays.sort(nums);
        if (nums[0] > 0) return List.of();
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i < n - 1; i++) {
            int l = 0, r = n - 1;
            while (l < i && r > i) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) break;
                else if (sum > 0) r--;
                else l++;
            }
            if (l < i && r > i && nums[i] + nums[l] + nums[r] == 0) {
                final List<Integer> num = List.of(nums[l], nums[i], nums[r]);
                final String flag = get(num);
                if (!vis.contains(flag)) {
                    ans.add(num);
                    vis.add(flag);
                }
            }
        }
        return ans;
    }

    private String get(List<Integer> nums) {
        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append("_").append(num);
        }
        return sb.toString();
    }
}