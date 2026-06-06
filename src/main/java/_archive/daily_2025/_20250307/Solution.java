package top.chenqwwq.leetcode.daily._2025._20250307;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenqwwq
 * @date 2025/3/8
 **/
public class Solution {
    int ans = 0;

    public int beautifulSubsets(int[] nums, int k) {
        // 回溯
        ans = 0;
        dfs(nums, 0, new HashMap<>(), k, 0);
        return ans;
    }

    private void dfs(int[] nums, int cur, Map<Integer, Integer> exist, int k, int cnt) {
        if (cur >= nums.length) {
            if (cnt > 0) {
                ans++;
            }
            return;
        }
        // 包含当前节点
        final int num = nums[cur];
        if (exist.getOrDefault(num - k, 0) <= 0 && exist.getOrDefault(num + k, 0) <= 0) {
            exist.put(num, exist.getOrDefault(num, 0) + 1);
            dfs(nums, cur + 1, exist, k, cnt + 1);
            exist.put(num, exist.get(num)-1);
        }
        dfs(nums, cur + 1, exist, k, cnt);
    }
}