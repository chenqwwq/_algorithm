package top.chenqwwq.leetcode.contest.biweek._85._4;

import java.util.*;

/**
 * @author chenqwwq
 * @date 2022/8/20
 **/
public class Solution {
    public long[] maximumSegmentSum(int[] nums, int[] removeQueries) {
        final int n = nums.length;
        TreeMap<Long, Long[]> map = new TreeMap<>();
        long max = 0;
        long[] ans = new long[n];
        for (int i = n - 1; i >= 0; i--) {
            ans[i] = max;
            int cur = removeQueries[i];
            long num = nums[cur];
            long left = cur, right = cur;
            Map.Entry<Long, Long[]> floor = map.floorEntry(left);
            if (floor != null && floor.getValue()[0] == left - 1) {
                left = floor.getKey();
                num += floor.getValue()[1];
                map.remove(floor.getKey());
            }
            if (map.containsKey(right + 1)) {
                Long[] entry = map.get(right + 1);
                map.remove(right + 1);
                right = entry[0];
                num += entry[1];
            }
            map.put(left, new Long[]{right, num});
            max = Math.max(max,num);
        }
        return ans;
    }
}