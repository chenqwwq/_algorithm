package top.chenqwwq.leetcode.daily._2022._20221008;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author chenqwwq
 * @date 2022/10/8
 **/
public class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        final int n = nums1.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums1) map.put(num, map.getOrDefault(num, 0) + 1);

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int target = nums2[i];
            Map.Entry<Integer, Integer> entry = map.higherEntry(target);
            if (entry == null) {
                entry = map.firstEntry();
            }
            ans[i] = entry.getKey();
            if (entry.getValue() == 1) map.remove(entry.getKey());
            else map.put(entry.getKey(), entry.getValue() - 1);
        }
        return ans;
    }
}