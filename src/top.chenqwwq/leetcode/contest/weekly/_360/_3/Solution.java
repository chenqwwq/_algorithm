package top.chenqwwq.leetcode.contest.weekly._360._3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenqwwq
 * @date 2023/8/27
 **/
public class Solution {
    Map<Integer, Integer> map = new HashMap<>();

    {
        for (int i = 0; i <= 30; i++) {
            map.put(1 << i, i);
        }
    }

    public int minOperations(List<Integer> nums, int target) {
        int[] vis = new int[32];
        long sum = 0;
        for (int num : nums) {
            sum += num;
            vis[map.get(num)]++;
        }
        if (sum < target) return -1;
        boolean[] exist = new boolean[32];
        for (int i = 0; i < 32; i++) {
            if ((target >> i & 1) == 1) exist[i] = true;
        }
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if (vis[i] <= 0 && !exist[i]) continue;
            if (exist[i]) {
                if (vis[i] > 0) vis[i]--;
                else {
                    for (int j = i + 1; j < 32; j++) {
                        if (vis[j] <= 0) continue;
                        vis[j]--;
                        for (int k = j - 1; k >= i; k--) vis[k] += 1;
                        vis[i]--;
                        ans += j - i;
                        break;
                    }
                }
            }
            if (i < 31) vis[i + 1] += vis[i] >> 1;
        }
        return ans;
    }
}