package top.chenqwwq.leetcode.contest.weekly._475._2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenqwwq
 * @date 2025/11/9
 **/
class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> pos = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
//            pos.computeIfAbsent(nums[i], _ -> new ArrayList<>()).add(i);
        }

        int ans = Integer.MAX_VALUE;
        for (List<Integer> p : pos.values()) {
            for (int i = 2; i < p.size(); i++) {
                ans = Math.min(ans, (p.get(i) - p.get(i - 2)) * 2);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}