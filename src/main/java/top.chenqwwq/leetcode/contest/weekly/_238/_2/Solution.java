package top.chenqwwq.leetcode.contest.weekly._238._2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chen
 * @date 2021-04-25
 **/
public class Solution {

    public int maxFrequency(int[] nums, int k) {
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i : nums) {
            hash.put(i, hash.getOrDefault(i, 0) + 1);
        }

        final List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(hash.entrySet());
        entries.sort((o1, o2) -> o2.getKey().compareTo(o1.getKey()));

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < entries.size(); i++) {
            final Map.Entry<Integer, Integer> f = entries.get(i);
            int cnt = f.getValue();
            int kk = k, target = f.getKey();
            for (int j = i + 1; j < entries.size() && kk > 0; j++) {
                final Map.Entry<Integer, Integer> e = entries.get(j);
                // 可以转化几个
                final int diff = target - e.getKey();
                final int add = Math.min(kk / diff, e.getValue());
                cnt += add;
                kk -= (add * diff);
                if (add < e.getValue()) {
                    break;
                }
            }
            ans = Math.max(ans, cnt);
        }

        return ans;
    }
}
