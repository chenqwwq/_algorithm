package top.chenqwwq.leetcode.contest.weekly._359._3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * @author chenqwwq
 * @date 2023/8/20
 **/
public class Solution {
    public int longestEqualSubarray(List<Integer> nums, int k) {
        final int n = nums.size();
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            final Integer num = nums.get(i);
            final List<Integer> list = map.getOrDefault(num, new ArrayList<>());
            list.add(i);
            map.put(num, list);
        }

        int ans = 0;
        for (List<Integer> vals : map.values()) {
            final int m = vals.size();
            int l = 0, r = 0;
            while (r < m) {
                int len = vals.get(r) - vals.get(l) + 1, cnt = r - l + 1, dc = len - cnt;
                if (dc > k) l++;
                else {
                    ans = Math.max(ans, r - l + 1);
                    r++;
                }
            }
        }

        return ans;
    }
}