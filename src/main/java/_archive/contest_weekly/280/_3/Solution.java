package top.chenqwwq.leetcode.contest.weekly._280._3;

import java.util.*;

/**
 * @author chen
 * @date 2022/2/13
 **/
public class Solution {
    public long minimumRemoval(int[] beans) {
        final int n = beans.length;
        Map<Integer, Integer> hash = new HashMap<>();
        long sum = 0;
        for (int bean : beans) {
            sum += bean;
            hash.put(bean, hash.getOrDefault(bean, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(hash.entrySet());
        list.sort(Comparator.comparingInt(Map.Entry::getKey));

        long ans = Long.MAX_VALUE, curr = 0, cnt = n;
        for (final Map.Entry<Integer, Integer> entry : list) {
            ans = Math.min(curr + sum - cnt * entry.getKey(), ans);
            cnt -= entry.getValue();
            sum -= (long) entry.getValue() * entry.getKey();
            curr += (long) entry.getValue() * entry.getKey();
        }
        return ans;
    }
}