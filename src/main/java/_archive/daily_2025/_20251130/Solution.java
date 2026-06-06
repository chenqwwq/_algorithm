package top.chenqwwq.leetcode.daily._2025._20251130;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenqwwq
 * @date 2025/11/30
 **/
public class Solution {
    public int minSubarray(int[] nums, int p) {
        final int n = nums.length;
        int[] ps = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ps[i] = (nums[i - 1] + ps[i - 1]) % p;
        }

        int m = ps[n] % p;      //  最终模
        if (m == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>(); // mod -> index
        int ans = 0x3f3f3f3f;
        for (int i = 0; i <= n; i++) {
            int mm = ps[i];
            int t2 = (mm - m + p) % p;
            if (map.containsKey(t2)) {
                ans = Math.min(ans, i - map.get(t2));
            }
            map.put(mm, i);
        }
        return ans;
    }
}