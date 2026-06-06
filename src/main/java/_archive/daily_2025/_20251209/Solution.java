package top.chenqwwq.leetcode.daily._2025._20251209;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenqwwq
 * @date 2025/12/13
 **/
public class Solution {

    public int specialTriplets(int[] nums) {
        int mod = 1000000007;
        long ans = 0;
        Map<Long, Integer> h1 = new HashMap<>(), h2 = new HashMap<>();
        for (int num : nums) h1.merge((long) num, 1, Integer::sum);

        for (int i = 0; i < nums.length; i++) {
            final long num = nums[i], t = num << 1;
            h1.merge(num, -1, Integer::sum);

            if (h1.getOrDefault(t, 0) > 0 && h2.getOrDefault(t, 0) > 0) {
                ans = (ans + (long) h1.get(t) * h2.get(t)) % mod;
            }

            h2.merge(num, 1, Integer::sum);
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        new Solution().specialTriplets(new int[]{37, 9, 24, 12, 12, 24, 52, 35});
    }
}