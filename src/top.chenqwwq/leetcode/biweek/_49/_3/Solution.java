package top.chenqwwq.leetcode.biweek._49._3;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chen
 * @date 2021/4/3
 **/
public class Solution {
    private static final long MOD = 1000000007L;

    public int countNicePairs(int[] nums) {
        Map<Long, Long> map = new HashMap<>();
        for (int num : nums) {
            long tem = num - getRev(num);
            map.put(tem, map.getOrDefault(tem, 0L) + 1L);
        }

        int ans = 0;
        for (long i : map.values()) {
            ans += (int) (i * (i - 1) / 2 % MOD);
        }


        return ans;
    }

    public int getRev(int num) {
        return Integer.parseInt(new StringBuffer(String.valueOf(num)).reverse().toString());
    }
}
