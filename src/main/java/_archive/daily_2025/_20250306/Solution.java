package top.chenqwwq.leetcode.daily._2025._20250306;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenqwwq
 * @date 2025/3/6
 **/
public class Solution {
    public long beautifulSubarrays(int[] nums) {
        long ans = 0;
        int cur = 0;
        final Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);

        for (int num : nums) {
            cur ^= num;
            final Integer cnt = map.getOrDefault(cur, 0);
            ans += cnt;
            map.put(cur, cnt + 1);
        }
        return ans;
    }
}